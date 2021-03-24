/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.pcm.controller;

import br.com.jump.core.controller.GenericCrudController;
import br.com.jump.model.pcm.TipoManutencao;
import br.com.jump.pcm.service.iface.ITipoManutencaoService;
import br.com.jump.core.service.iface.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author macorin
 */
@Controller
@RequestMapping(value = "/tipoManutencao")
public class TipoManutencaoController extends GenericCrudController<TipoManutencao, Long> {

    @Autowired
    private ITipoManutencaoService tipoManutencaoService;

    @Override
    protected String[] getCamposDataTable() {
        return new String[]{
            "tmId",
            "tmDescricao",
            "tmAtivo"
        };
    }

    @Override
    protected IGenericService<TipoManutencao, Long> getService() {
        return tipoManutencaoService;
    }
}
