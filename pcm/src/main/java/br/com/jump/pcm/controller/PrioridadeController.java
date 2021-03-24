/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.pcm.controller;

import br.com.jump.core.controller.GenericCrudController;
import br.com.jump.model.pcm.Prioridade;
import br.com.jump.pcm.service.iface.IPrioridadeService;
import br.com.jump.core.service.iface.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author macorin
 */
@Controller
@RequestMapping(value = "/prioridade")
public class PrioridadeController extends GenericCrudController<Prioridade, Long> {

    @Autowired
    private IPrioridadeService prioridadeService;
    
    @Override
    protected String[] getCamposDataTable() {
        return new String[]{
            "prId",
            "prDescricao",
            "prAtivo"
        };
    }

    @Override
    protected IGenericService<Prioridade, Long> getService() {
        return prioridadeService;
    }
}
