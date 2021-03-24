package br.com.jump.pessoa.controller;

import br.com.jump.core.controller.GenericCrudController;
import br.com.jump.core.service.iface.IGenericService;
import br.com.jump.model.dto.DataTableResponse;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.pessoa.Localidade;
import br.com.jump.pessoa.service.iface.ILocalidadeService;
import br.com.jump.pessoa.service.iface.IUnidadeFederacaoService;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/localidade")
public class LocalidadeController extends GenericCrudController<Localidade, Long> {

    @Autowired
    private ILocalidadeService localidadeService;

    @Autowired
    private IUnidadeFederacaoService unidadeFederacaoService;

    @Override
    protected String[] getCamposDataTable() {
        return new String[]{
                "locId",
                "locNome",
                "unidadeFederacao.unfSigla",
                "locCodigoIbge"
        };
    }

    @Override
    protected IGenericService getService() {
        return localidadeService;
    }

    @Override
    protected void adicionarParametros(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("columnsUnidadeFederacao", new String[]{
                "unfId",
                "unfSigla",
                "unfNome"
        });
    }

    @Override
    protected void adicionarParametrosNovo(ModelAndView modelAndView, HttpServletRequest request) {
        Localidade localidade = (Localidade) modelAndView.getModel().get("model");

        localidade.setSituacao(ESituacao.Ativo);
        localidade.setDataCriacao(new LocalDateTime());
        localidade.setDataAlteracao(new LocalDateTime());

        localidade.setGrupoEmpresa(usuarioLogado(request).getGrupoEmpresa());

        modelAndView.getModel().put("model", localidade);
    }

    @Override
    protected void adicionarParametrosEditar(Long id, ModelAndView modelAndView, HttpServletRequest request) {
        Localidade localidade = (Localidade) modelAndView.getModel().get("model");

        localidade.setDataAlteracao(new LocalDateTime());

        modelAndView.getModel().put("model", localidade);
    }

    @ResponseBody
    @RequestMapping(value = "/loadUnidadeFederacaoAjax.do", method = RequestMethod.GET)
    public DataTableResponse loadUnidadeFederacao (
            @RequestParam(value = "sEcho") String sEcho,
            @RequestParam(value = "sSearch") String sSearch,
            @RequestParam(value = "iDisplayStart") int startRow,
            @RequestParam(value = "iDisplayLength") int maxResults,
            @RequestParam(value = "iSortCol_0", required = false) Integer sortColumnIndex,
            @RequestParam(value = "sSortDir_0", required = false) String sortDirection,
            HttpServletRequest request) {
        return unidadeFederacaoService.buscarDataTableResponse(sEcho, sSearch, new String[]{"unfId", "unfSigla", "unfNome"}, startRow, maxResults, sortColumnIndex, sSearch);
    }
}
