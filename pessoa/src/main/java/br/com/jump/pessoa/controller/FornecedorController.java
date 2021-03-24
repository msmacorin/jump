package br.com.jump.pessoa.controller;

import br.com.jump.core.controller.GenericCrudController;
import br.com.jump.core.service.iface.IGenericService;
import br.com.jump.model.admin.Usuario;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.enums.ETipoPessoa;
import br.com.jump.model.pessoa.Fornecedor;
import br.com.jump.model.pessoa.Pessoa;
import br.com.jump.pessoa.service.iface.IFornecedorService;
import br.com.jump.pessoa.service.iface.IPessoaService;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by macorin on 05/08/14.
 */
@Controller
@RequestMapping(value = "/fornecedor")
@SessionAttributes({"fornecedor"})
public class FornecedorController extends GenericCrudController<Fornecedor, Long> {

    @Autowired
    private IFornecedorService fornecedorService;

    @Autowired
    private IPessoaService pessoaService;

    @Override
    protected String[] getCamposDataTable() {
        return new String[]{
                "forId",
                "pessoa.pesIdentificacao",
                "pessoa.pesNome"
        };
    }

    @Override
    protected IGenericService<Fornecedor, Long> getService() {
        return fornecedorService;
    }

    /**
     * sobrepondo metodo para salvar a pessoa antes de salvar o fornecedor.
     *
     * @param entidade
     * @param result
     * @param request
     * @return
     */
    @Override
    public ModelAndView salvar(@ModelAttribute(value = "model") Fornecedor entidade, BindingResult result, HttpServletRequest request) {
        pessoaService.salvar(entidade.getPessoa());

        return super.salvar(entidade, result, request);
    }

    /**
     * metodo chamado pelo tablecrud quando selecionado o novo.
     * redireciona para a tela de search do fornecedor.
     *
     * @return
     */
    @RequestMapping(value = "/search.do", method = RequestMethod.GET)
    public ModelAndView searchPessoa() {
        ModelAndView modelAndView = new ModelAndView("fornecedor/fornecedorSearch");

        modelAndView.addObject("listTipoPessoa", ETipoPessoa.values());

        return modelAndView;
    }

    /**
     * verifica se existe uma pessoa com o CPF/CNPJ digitados.
     * caso não exista vai redirecionar para a tela de cadastro
     * caso exista vai buscar o fornecedor, se não existir vai redirecionar para a tela de cadastro
     * caso exista o fornecedor, redireciona para edição.
     *
     * @param tipoPessoa
     * @param identificacao
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/search.do", method = RequestMethod.POST)
    public String searchPessoa(@RequestParam(value = "tipoPessoa") ETipoPessoa tipoPessoa,
                               @RequestParam(value = "identificacao") String identificacao,
                               HttpServletRequest request,
                               ModelMap modelMap) {
        Usuario usuario = usuarioLogado(request);

        /**
         * primeiro vai procurar a pessoa pelo tipo e numero de identificacao, pois pode
         * ser que exista a pessoa vinculada a fornecedor ou outra entidade.
         */
        Pessoa pessoa = pessoaService.buscarPorTipoIdentificacao(usuario.getGrupoEmpresa().getGreId(),
                tipoPessoa,
                identificacao);

        Fornecedor fornecedor = null;
        String requestMapping = null;

        if (pessoa != null) {
            /**
             * se a pessoa existir vai verificar se existe o fornecedor.
             */
            fornecedor = fornecedorService.buscarPorPessoa(pessoa.getPesId());
        }

        if (fornecedor == null) {
            requestMapping = "redirect:newfornecedor.do";

            fornecedor = new Fornecedor();

            fornecedor.setPessoa(pessoa != null ? pessoa : new Pessoa());
            fornecedor.setDataCriacao(new LocalDateTime());
            fornecedor.setSituacao(ESituacao.Ativo);

            if (pessoa == null) {
                fornecedor.getPessoa().setPesTipoPessoa(tipoPessoa);
                fornecedor.getPessoa().setPesIdentificacao(identificacao);

                fornecedor.getPessoa().setSituacao(ESituacao.Ativo);
                fornecedor.getPessoa().setDataCriacao(new LocalDateTime());
                fornecedor.getPessoa().setGrupoEmpresa(usuario.getGrupoEmpresa());
            }
        } else {
            requestMapping = "redirect:editfornecedor.do";
        }

        fornecedor.setDataAlteracao(new LocalDateTime());
        fornecedor.getPessoa().setDataAlteracao(new LocalDateTime());

        /**
         * isso é feito apenas para mudar a url de seach para new ou edit do fornecedor.
         */
        modelMap.addAttribute(fornecedor);
        return requestMapping;
    }

    @RequestMapping(value = "/newfornecedor.do", method = RequestMethod.GET)
    public ModelAndView newfornecedor(@ModelAttribute(value = "fornecedor") Fornecedor fornecedor) {
        ModelAndView view = new ModelAndView("fornecedor/fornecedorForm");
        view.addObject("model", fornecedor);

        return view;
    }

    @RequestMapping(value = "/editfornecedor.do")
    public ModelAndView editfornecedor(@ModelAttribute(value = "fornecedor") Fornecedor fornecedor) {
        ModelAndView view = new ModelAndView("fornecedor/fornecedorForm");
        view.getModel().put("model", fornecedor);

        return view;
    }
}
