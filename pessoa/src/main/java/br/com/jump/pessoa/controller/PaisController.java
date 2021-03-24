package br.com.jump.pessoa.controller;

import br.com.jump.core.controller.GenericCrudController;
import br.com.jump.core.service.iface.IGenericService;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.pessoa.Pais;
import br.com.jump.pessoa.service.iface.IPaisService;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/pais")
public class PaisController extends GenericCrudController<Pais, Long> {

    @Autowired
    private IPaisService paisService;

    @Override
    protected String[] getCamposDataTable() {
        return new String[]{
                "paiId",
                "paiNome",
                "paiCodigoBancoCentral"
        };
    }

    @Override
    protected IGenericService<Pais, Long> getService() {
        return paisService;
    }

    @Override
    protected void adicionarParametrosNovo(ModelAndView modelAndView, HttpServletRequest request) {
        Pais pais = (Pais) modelAndView.getModel().get("model");

        pais.setSituacao(ESituacao.Ativo);
        pais.setDataCriacao(new LocalDateTime());
        pais.setDataAlteracao(new LocalDateTime());

        pais.setGrupoEmpresa(usuarioLogado(request).getGrupoEmpresa());

        modelAndView.getModel().put("model", pais);
    }

    @Override
    protected void adicionarParametrosEditar(Long id, ModelAndView modelAndView, HttpServletRequest request) {
        Pais pais = (Pais) modelAndView.getModel().get("model");

        pais.setDataAlteracao(new LocalDateTime());

        modelAndView.getModel().put("model", pais);
    }
}
