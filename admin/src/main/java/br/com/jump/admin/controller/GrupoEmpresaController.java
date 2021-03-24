/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.admin.controller;

import br.com.jump.core.annotation.AcessoAdministradorPermitido;
import br.com.jump.core.controller.GenericCrudController;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.admin.GrupoEmpresa;
import br.com.jump.core.service.iface.IGrupoEmpresaService;
import br.com.jump.core.service.iface.IGenericService;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author macorin
 */
@Controller
@RequestMapping(value = "/grupoEmpresa")
public class GrupoEmpresaController extends GenericCrudController<GrupoEmpresa, Long> {

    @Autowired
    private IGrupoEmpresaService grupoEmpresaService;
    
    @Override
    protected String[] getCamposDataTable() {
        return new String[]{
            "greId",
            "greNome"
        };
    }

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
    public ModelAndView salvar(@ModelAttribute(value = "model") GrupoEmpresa entidade, BindingResult result, HttpServletRequest request) {
        return super.salvar(entidade, result, request);
    }

    @Override
    protected void adicionarParametrosNovo(ModelAndView modelAndView, HttpServletRequest request) {
        GrupoEmpresa grupoEmpresa = (GrupoEmpresa) modelAndView.getModel().get("model");

        grupoEmpresa.setSituacao(ESituacao.Ativo);
        grupoEmpresa.setDataCriacao(new LocalDateTime());
        grupoEmpresa.setDataAlteracao(new LocalDateTime());

        modelAndView.addObject("model", grupoEmpresa);
    }

    @Override
    protected void adicionarParametrosEditar(Long id, ModelAndView modelAndView, HttpServletRequest request) {
        GrupoEmpresa grupoEmpresa = (GrupoEmpresa) modelAndView.getModel().get("model");

        grupoEmpresa.setDataAlteracao(new LocalDateTime());

        modelAndView.addObject("model", grupoEmpresa);
    }
    
    @Override
    protected IGenericService<GrupoEmpresa, Long> getService() {
        return grupoEmpresaService;
    }
}
