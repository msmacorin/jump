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
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author macorin
 */
@Controller
@RequestMapping(value = "/alterarSenha")
public class AlterarSenhaController extends GenericCrudController<Usuario, Long>{

    @Autowired
    IUsuarioService usuarioService;
    
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
}
