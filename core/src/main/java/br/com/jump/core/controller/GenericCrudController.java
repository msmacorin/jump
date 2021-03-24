package br.com.jump.core.controller;

import br.com.jump.core.annotation.AcessoAdministradorPermitido;
import br.com.jump.core.service.iface.IGenericService;
import br.com.jump.core.util.BeanUtil;
import br.com.jump.model.admin.ParametroSistema;
import br.com.jump.model.admin.Usuario;
import br.com.jump.model.dto.DataTableResponse;
import in.macor.commons.util.MessageUtil;
import in.macor.commons.util.StringUtil;
import in.macor.core.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.ParameterizedType;

/**
 * @author macorin
 */
public abstract class GenericCrudController<T, PK> {

    private final Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    protected final ModelAndView HOME = new ModelAndView("index");
    protected final Logger logger = LoggerFactory.getLogger(clazz);

    @Autowired
    protected Validator validator;

    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(String.format("%s/%sIndex", getPastaComViews(), classLowerCase()));
        modelAndView.addObject("camposTableCrud", getCamposDataTable());

        return modelAndView;
    }

    @RequestMapping(value = "/novo.do", method = RequestMethod.GET)
    public ModelAndView novo(HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        ModelAndView modelAndView = new ModelAndView(String.format("%s/%sForm", getPastaComViews(), classLowerCase()));

        T instance1 = clazz.newInstance();
        T instance = instance1;

        modelAndView.addObject("model", instance);

        adicionarParametros(modelAndView, request);
        adicionarParametrosNovo(modelAndView, request);

        return modelAndView;
    }

    @RequestMapping(value = "/editar.do", method = RequestMethod.GET)
    public ModelAndView editar(@RequestParam(value = "id") PK id, HttpServletRequest request) {
        T entidade = getService().buscarPorId(id);

        ModelAndView modelAndView;
        if (entidade != null) {
            if (podeEditar(entidade)) {
                modelAndView = new ModelAndView(String.format("%s/%sForm", getPastaComViews(), classLowerCase()));
                modelAndView.addObject("model", entidade);

                adicionarParametros(modelAndView, request);
                adicionarParametrosEditar(id, modelAndView, request);
            } else {
                modelAndView = index();
                modelAndView.addObject(MessageUtil.ALERTA, String.format("%s.nao.pode.editar", entidadeLowerCase()));
            }
        } else {
            modelAndView = index();
            modelAndView.addObject(MessageUtil.ERRO, String.format("%s.nao.encontrado", entidadeLowerCase()));
        }
        return modelAndView;
    }

    @RequestMapping(value = "/salvar.do", method = RequestMethod.POST)
    public ModelAndView salvar(@ModelAttribute(value = "model") T entidade, BindingResult result, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(String.format("%s/%sForm", getPastaComViews(), classLowerCase()));
        modelAndView.addObject("model", entidade);

        // seta nulo em relacionamentos vindos da tela
        BeanUtil.detachedToPersist(entidade);

        antesDeSalvar(entidade, modelAndView, request);

        try {
            validator.validate(entidade, result);
            if (!result.hasErrors()) {
                getService().salvar(entidade);
                modelAndView = index();
                modelAndView.addObject(MessageUtil.SUCESSO, String.format("%s.salvo.com.sucesso", entidadeLowerCase()));
            } else {
                StringBuilder erros = new StringBuilder();

                for (ObjectError erro : result.getAllErrors()) {
                    erros.append(erro.toString()).append("\n");
                }

                modelAndView.addObject(MessageUtil.ERRO, String.format("Erro: %s", erros.toString()));
            }
        } catch (ServiceException e) {
            adicionarParametros(modelAndView, request);
            modelAndView.addObject(MessageUtil.ERRO, e.getMessageKey());
            modelAndView.addObject(MessageUtil.ARGUMENTOS, e.getFormattedArguments());
        } catch (RuntimeException e) {
            adicionarParametros(modelAndView, request);
            modelAndView.addObject(MessageUtil.RUNTIME, e.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/deletar.do", method = RequestMethod.GET)
    public ModelAndView deletar(@RequestParam(value = "id") PK id) {
        ModelAndView index = index();
        if (podeExcluir(id)) {
            try {
                getService().deletar(id);
                index.addObject(MessageUtil.SUCESSO, String.format("%s.removido.com.sucesso", entidadeLowerCase()));
            } catch (ServiceException e) {
                index.addObject(MessageUtil.ERRO, e.getMessageKey());
            }
        } else {
            index.addObject(MessageUtil.ALERTA, String.format("%s.nao.pode.deletar", entidadeLowerCase()));
        }

        return index;
    }

    @RequestMapping(value = "/loadDataAjax.do", method = RequestMethod.GET)
    @ResponseBody
    public DataTableResponse loadAjaxData(
            @RequestParam(value = "sEcho") String sEcho,
            @RequestParam(value = "sSearch") String sSearch,
            @RequestParam(value = "iDisplayStart") int startRow,
            @RequestParam(value = "iDisplayLength") int maxResults,
            @RequestParam(value = "iSortCol_0", required = false) Integer sortColumnIndex,
            @RequestParam(value = "sSortDir_0", required = false) String sortDirection,
            HttpServletRequest request) {

        return getService().buscarDataTableResponse(sEcho, sSearch, getCamposDataTable(),
                startRow, maxResults, sortColumnIndex, sortDirection);
    }

    protected String getPastaComViews() {
        return classLowerCase();
    }

    /**
     * @param request
     * @return Usuario logado no service.
     */
    protected Usuario usuarioLogado(HttpServletRequest request) {
        return (Usuario) request.getAttribute(ParametroSistema.USUARIO_LOGADO);
    }

    protected abstract String[] getCamposDataTable();

    protected abstract IGenericService<T, PK> getService();

    /**
     * Metodo para adicionar parametros ao model apenas ao adicionar registros.
     *
     * @param modelAndView
     */
    protected void adicionarParametrosNovo(ModelAndView modelAndView, HttpServletRequest request) {
    }

    /**
     * Metodo para adicionar parametros ao model apenas ao editar registros.
     *
     * @param id           - id do registro.
     * @param modelAndView
     */
    protected void adicionarParametrosEditar(PK id, ModelAndView modelAndView, HttpServletRequest request) {
    }

    /**
     * Metodo para adicionar parametros ao model sempre que abrir o form.
     *
     * @param modelAndView
     */
    protected void adicionarParametros(ModelAndView modelAndView, HttpServletRequest request) {
    }

    /**
     * Metodo para validar se o registro pode editar o registro
     *
     * @param entidade editada
     * @return
     */
    protected boolean podeEditar(T entidade) {
        return true;
    }

    /**
     * Metodo para validar se o registro pode ser excluido
     *
     * @param id
     * @return
     */
    protected boolean podeExcluir(PK id) {
        return true;
    }

    /**
     * Metodo chamado antes de persistir os dados da tela no banco.
     *
     * @param entidade     - registro a ser persistido.
     * @param modelAndView
     * @param request
     */
    protected void antesDeSalvar(T entidade, ModelAndView modelAndView, HttpServletRequest request) throws ServiceException {
    }

    private String entidadeLowerCase() {
        return StringUtil.uncapitalize(clazz.getSimpleName());
    }

    private String classLowerCase() {
        return StringUtil.uncapitalize(getClass().getSimpleName().replace("Controller", ""));
    }
}
