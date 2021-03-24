package br.com.jump.pessoa.controller;

import br.com.jump.core.controller.GenericCrudController;
import br.com.jump.core.service.iface.IGenericService;
import br.com.jump.core.service.iface.IGrupoEmpresaService;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.pessoa.TipoEndereco;
import br.com.jump.pessoa.service.iface.ITipoEnderecoService;
import in.macor.core.exception.ServiceException;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/tipoEndereco")
public class TipoEnderecoController extends GenericCrudController<TipoEndereco, Long> {

    @Autowired
    private ITipoEnderecoService tipoEnderecoService;

    @Override
    protected String[] getCamposDataTable() {
        return new String[]{
                "tieId",
                "tieNome"
        };
    }

    @Override
    protected IGenericService<TipoEndereco, Long> getService() {
        return tipoEnderecoService;
    }

    @Override
    protected void adicionarParametrosNovo(ModelAndView modelAndView, HttpServletRequest request) {
        TipoEndereco tipoEndereco = (TipoEndereco) modelAndView.getModel().get("model");

        tipoEndereco.setSituacao(ESituacao.Ativo);
        tipoEndereco.setDataCriacao(new LocalDateTime());
        tipoEndereco.setDataAlteracao(new LocalDateTime());
        
        tipoEndereco.setGrupoEmpresa(usuarioLogado(request).getGrupoEmpresa());

        modelAndView.getModel().put("model", tipoEndereco);
    }

    @Override
    protected void adicionarParametrosEditar(Long id, ModelAndView modelAndView, HttpServletRequest request) {
        TipoEndereco tipoEndereco = (TipoEndereco) modelAndView.getModel().get("model");

        tipoEndereco.setDataAlteracao(new LocalDateTime());

        modelAndView.getModel().put("model", tipoEndereco);
    }

    @Override
    protected void adicionarParametros(ModelAndView modelAndView, HttpServletRequest request) {
        TipoEndereco tipoEndereco = (TipoEndereco) modelAndView.getModel().get("model");

        modelAndView.getModel().put("model", tipoEndereco);
    }

}
