package br.com.jump.admin.controller;

import br.com.jump.core.service.iface.IGrupoEmpresaService;
import br.com.jump.admin.service.iface.ILicencaService;
import br.com.jump.core.controller.GenericCrudController;
import br.com.jump.core.service.iface.IGenericService;
import br.com.jump.model.dto.DataTableResponse;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.admin.Licenca;
import br.com.jump.model.admin.ParametroSistema;
import in.macor.core.exception.ServiceException;
import in.macor.core.security.PassGenerated;
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
@RequestMapping(value = "/licenca")
public class LicencaController extends GenericCrudController<Licenca, Long> {

    @Autowired
    private ILicencaService licencaService;

    @Autowired
    private IGrupoEmpresaService grupoEmpresaService;

    @Override
    protected String[] getCamposDataTable() {
        return new String[] {
                "licId",
                "grupoEmpresa.greNome",
                "licInicio",
                "licPrazo"
        };
    }

    @Override
    protected void adicionarParametros(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("columnsGrupoEmpresa", new String[]{
                "greId",
                "greNome"
        });
    }

    @Override
    protected void adicionarParametrosNovo(ModelAndView modelAndView, HttpServletRequest request) {
        Licenca licenca = (Licenca) modelAndView.getModel().get("model");

        licenca.setSituacao(ESituacao.Ativo);
        licenca.setDataCriacao(new LocalDateTime());
        licenca.setDataAlteracao(new LocalDateTime());

        modelAndView.addObject("model", licenca);
    }

    @Override
    protected void adicionarParametrosEditar(Long id, ModelAndView modelAndView, HttpServletRequest request) {
        Licenca licenca = (Licenca) modelAndView.getModel().get("model");

        licenca.setDataAlteracao(new LocalDateTime());

        modelAndView.addObject("model", licenca);
    }

    @Override
    protected void antesDeSalvar(Licenca entidade, ModelAndView modelAndView, HttpServletRequest request) throws ServiceException {
        if (entidade.getLicValidacao() == null) {
            entidade.setLicValidacao(PassGenerated.generated(entidade.getLicInicio().toLocalDate(), ParametroSistema.TAMANHO_VALIDACAO_LICENCA));
        }
    }

    @ResponseBody
    @RequestMapping(value = "/loadGrupoEmpresaAjax.do", method = RequestMethod.GET)
    public DataTableResponse loadGrupoEmpresa(
            @RequestParam(value = "sEcho") String sEcho,
            @RequestParam(value = "sSearch") String sSearch,
            @RequestParam(value = "iDisplayStart") int startRow,
            @RequestParam(value = "iDisplayLength") int maxResults,
            @RequestParam(value = "iSortCol_0", required = false) Integer sortColumnIndex,
            @RequestParam(value = "sSortDir_0", required = false) String sortDirection,
            HttpServletRequest request) {
        return grupoEmpresaService.buscarDataTableResponse(sEcho, sSearch, new String[]{"greId", "greNome"}, startRow, maxResults, sortColumnIndex, sSearch);
    }

    @Override
    protected IGenericService<Licenca, Long> getService() {
        return licencaService;
    }
}
