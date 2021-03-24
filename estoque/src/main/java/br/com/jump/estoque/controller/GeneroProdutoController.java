/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.estoque.controller;

import br.com.jump.core.controller.GenericCrudController;
import br.com.jump.model.estoque.GeneroProduto;
import br.com.jump.core.service.iface.IGenericService;
import org.springframework.stereotype.Controller;

/**
 *
 * @author macorin
 */
@Controller
public class GeneroProdutoController extends GenericCrudController<GeneroProduto, Long>{

    @Override
    protected String[] getCamposDataTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected IGenericService<GeneroProduto, Long> getService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
