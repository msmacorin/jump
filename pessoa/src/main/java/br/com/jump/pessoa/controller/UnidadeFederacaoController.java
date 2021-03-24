package br.com.jump.pessoa.controller;

import br.com.jump.core.controller.GenericCrudController;
import br.com.jump.core.service.iface.IGenericService;
import br.com.jump.model.dto.DataTableResponse;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.pessoa.UnidadeFederacao;
import br.com.jump.pessoa.service.iface.IPaisService;
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
@RequestMapping(value = "/unidadeFederacao")
public class UnidadeFederacaoController extends GenericCrudController<UnidadeFederacao, Long> {

    @Autowired
    private IUnidadeFederacaoService unidadeFederacaoService;

    @Autowired
    private IPaisService paisService;

    @Override
    protected String[] getCamposDataTable() {
        return new String[] {
                "unfId",
                "unfNome",
                "unfSigla"
        };
    }

    @Override
    protected void adicionarParametros(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("columnsPais", new String[]{
                "paiId",
                "paiNome"
        });
    }

    @Override
    protected IGenericService<UnidadeFederacao, Long> getService() {
        return unidadeFederacaoService;
    }

    @Override
    protected void adicionarParametrosNovo(ModelAndView modelAndView, HttpServletRequest request) {
        UnidadeFederacao unidadeFederacao = (UnidadeFederacao) modelAndView.getModel().get("model");

        unidadeFederacao.setSituacao(ESituacao.Ativo);
        unidadeFederacao.setDataCriacao(new LocalDateTime());
        unidadeFederacao.setDataAlteracao(new LocalDateTime());

        unidadeFederacao.setGrupoEmpresa(usuarioLogado(request).getGrupoEmpresa());

        modelAndView.getModel().put("model", unidadeFederacao);
    }

    @Override
    protected void adicionarParametrosEditar(Long id, ModelAndView modelAndView, HttpServletRequest request) {
        UnidadeFederacao unidadeFederacao = (UnidadeFederacao) modelAndView.getModel().get("model");

        unidadeFederacao.setDataAlteracao(new LocalDateTime());

        modelAndView.getModel().put("model", unidadeFederacao);
    }

    @ResponseBody
    @RequestMapping(value = "/loadPaisAjax.do", method = RequestMethod.GET)
    public DataTableResponse loadPais(
            @RequestParam(value = "sEcho") String sEcho,
            @RequestParam(value = "sSearch") String sSearch,
            @RequestParam(value = "iDisplayStart") int startRow,
            @RequestParam(value = "iDisplayLength") int maxResults,
            @RequestParam(value = "iSortCol_0", required = false) Integer sortColumnIndex,
            @RequestParam(value = "sSortDir_0", required = false) String sortDirection,
            HttpServletRequest request) {
        return paisService.buscarDataTableResponse(sEcho, sSearch, new String[]{"paiId", "paiNome"}, startRow, maxResults, sortColumnIndex, sSearch);
    }
}
