/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.admin.controller;

import br.com.jump.core.annotation.AcessoAdministradorPermitido;
import br.com.jump.core.annotation.AcessoAnonimoPermitido;
import br.com.jump.core.controller.GenericCrudController;
import br.com.jump.model.dto.DataTableResponse;
import br.com.jump.model.enums.ESimNao;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.admin.Usuario;
import br.com.jump.core.service.iface.IGrupoEmpresaService;
import br.com.jump.admin.service.iface.IUsuarioService;
import br.com.jump.core.service.iface.IGenericService;
import in.macor.commons.util.SecurityUtil;
import in.macor.core.exception.ServiceException;
import in.macor.core.security.PassGenerated;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macorin
 */
@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController extends GenericCrudController<Usuario, Long> {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IGrupoEmpresaService grupoEmpresaService;

    @Override
    @AcessoAdministradorPermitido
    public ModelAndView index() {
        return super.index();
    }

    @Override
    @AcessoAdministradorPermitido
    public ModelAndView novo(HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        return super.novo(request);
    }

    @Override
    @AcessoAdministradorPermitido
    public ModelAndView editar(@RequestParam(value = "id") Long id, HttpServletRequest request) {
        return super.editar(id, request);
    }

    @Override
    @AcessoAdministradorPermitido
    public ModelAndView salvar(@ModelAttribute(value = "model") Usuario entidade, BindingResult result, HttpServletRequest request) {
        return super.salvar(entidade, result, request);
    }

    @Override
    protected String[] getCamposDataTable() {
        return new String[]{
            "usuId",
            "usuNome",
            "usuEmail"
        };
    }

    @Override
    protected void adicionarParametros(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("listaSimNao", ESimNao.values());
        modelAndView.addObject("columnsGrupoEmpresa", new String[]{
            "greId",
            "greNome"
        });
    }

    @Override
    protected void adicionarParametrosEditar(Long id, ModelAndView modelAndView, HttpServletRequest request) {
        Usuario usuario = (Usuario) modelAndView.getModel().get("model");
        usuario.setDataAlteracao(new LocalDateTime());
        usuario.setUsuSenha(null); // obriga a digitar senha

        modelAndView.addObject("model", usuario);
    }

    @Override
    protected void adicionarParametrosNovo(ModelAndView modelAndView, HttpServletRequest request) {
        Usuario usuario = (Usuario) modelAndView.getModel().get("model");

        usuario.setSituacao(ESituacao.Ativo);
        usuario.setDataCriacao(new LocalDateTime());
        usuario.setDataAlteracao(new LocalDateTime());

        modelAndView.addObject("model", usuario);
    }

    @Override
    protected void antesDeSalvar(Usuario entidade, ModelAndView modelAndView, HttpServletRequest request) {
        try {
            entidade.setUsuSenha(SecurityUtil.encrypt(entidade.getUsuSenha()));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException(ex.getMessage());
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    protected IGenericService<Usuario, Long> getService() {
        return usuarioService;
    }

    @Override
    protected boolean podeEditar(Usuario entidade) {
        // apenas o proprio usuario pode editar, pra poder validar o e-mail e usuario.
        return false;
    }
    
    @ResponseBody
    @RequestMapping(value = "/ajaxCheckMail.do", method = RequestMethod.GET)
    public Boolean checkMail(@RequestParam(value = "usuEmail") String email) {
        Usuario usuarioBD = usuarioService.buscarPorEmail(email);
        
        if (usuarioBD != null) {
            return Boolean.FALSE;
        }
        
        return Boolean.TRUE;
    }

    @ResponseBody
    @RequestMapping(value = "/ajaxCheckUser.do", method = RequestMethod.GET)
    public Boolean checkUser(@RequestParam(value = "usuUsuario") String usuario) {
        Usuario usuarioBD = usuarioService.buscarPorUsuario(usuario);
        
        if (usuarioBD != null) {
            return Boolean.FALSE;
        }
        
        return Boolean.TRUE;
    }
    
    @Override
    public ModelAndView deletar(Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        usuario.setSituacao(ESituacao.Excluido);
        usuario.setDataAlteracao(new LocalDateTime());

        usuarioService.salvar(usuario);

        return index();
    }

    @AcessoAnonimoPermitido
    @RequestMapping(value = "/adminPass.do")
    public ModelAndView adminPassword() {
        ModelAndView view = new ModelAndView("usuario/adminPassForm");
        view.addObject("dataSenha", new LocalDate().toString("dd/MM/yyyy"));
        view.addObject("senhaAdmin", PassGenerated.generatedAdminPassword());

        return view;
    }

    @ResponseBody
    @RequestMapping(value = "/loadGrupoEmpresaAjax.do", method = RequestMethod.GET)
    public DataTableResponse loadGrupoEmpresa(
            @RequestParam(value = "sEcho") String sEcho,
            @RequestParam(value = "sSearch") String sSearch,
            @RequestParam(value = "iDisplayStart") int startRow,
            @RequestParam(value = "iDisplayLength") int maxResults,
            @RequestParam(value = "iSortCol_0", required = false) Integer sortColumnIndex,
            @RequestParam(value = "sSortDir_0", required = false) String sortDirection,
            HttpServletRequest request) {
        return grupoEmpresaService.buscarDataTableResponse(sEcho, sSearch, new String[]{"greId", "greNome"}, startRow, maxResults, sortColumnIndex, sSearch);
    }
}
