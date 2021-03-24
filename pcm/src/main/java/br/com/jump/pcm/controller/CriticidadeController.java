/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.pcm.controller;

import br.com.jump.core.controller.GenericCrudController;
import br.com.jump.model.pcm.Criticidade;
import br.com.jump.pcm.service.iface.ICriticidadeService;
import br.com.jump.core.service.iface.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author macorin
 */
@Controller
@RequestMapping(value = "/criticidade")
public class CriticidadeController extends GenericCrudController<Criticidade, Long> {

    @Autowired
    private ICriticidadeService criticidadeService;
    
    @Override
    protected String[] getCamposDataTable() {
        return new String[]{
            "crId",
            "crDescricao",
            "crAtivo"
        };
    }

    @Override
    protected IGenericService<Criticidade, Long> getService() {
        return criticidadeService;
    }
}
