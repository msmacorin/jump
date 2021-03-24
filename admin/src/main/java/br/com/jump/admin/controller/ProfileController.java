/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.admin.controller;

import br.com.jump.core.controller.GenericCrudController;
import br.com.jump.model.admin.Usuario;
import br.com.jump.admin.service.iface.IUsuarioService;
import br.com.jump.core.service.iface.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author macorin
 */
@Controller
@RequestMapping(value = "/profile")
public class ProfileController extends GenericCrudController<Usuario, Long>{

    @Autowired
    private IUsuarioService usuarioService;
    
    @Override
    protected String[] getCamposDataTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected IGenericService<Usuario, Long> getService() {
        return usuarioService;
    }

    @Override
    public ModelAndView index() {
        return super.HOME;
    }
    
    @ResponseBody
    @RequestMapping(value = "/ajaxCheckMail.do", method = RequestMethod.GET)
    public Boolean checkMail(@RequestParam(value = "usEmail") String email,
                             HttpServletRequest request) {
        Usuario usuarioBD = usuarioService.buscarPorEmail(email);
        Usuario usuarioLogado = usuarioLogado(request);
        
        if (usuarioBD != null &&
            !usuarioBD.equals(usuarioLogado)) {
            return Boolean.FALSE;
        }
        
        return Boolean.TRUE;
    }

    @ResponseBody
    @RequestMapping(value = "/ajaxCheckUser.do", method = RequestMethod.GET)
    public Boolean checkUser(@RequestParam(value = "usUsuario") String usuario,
                             HttpServletRequest request) {
        Usuario usuarioBD = usuarioService.buscarPorUsuario(usuario);
        Usuario usuarioLogado = usuarioLogado(request);
        
        if (usuarioBD != null &&
            !usuarioBD.equals(usuarioLogado)) {
            return Boolean.FALSE;
        }
        
        return Boolean.TRUE;
    }
}
