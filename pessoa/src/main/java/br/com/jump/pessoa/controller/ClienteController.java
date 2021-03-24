package br.com.jump.pessoa.controller;

import br.com.jump.core.controller.GenericCrudController;
import br.com.jump.core.service.iface.IGenericService;
import br.com.jump.model.admin.Usuario;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.enums.ETipoPessoa;
import br.com.jump.model.pessoa.Cliente;
import br.com.jump.model.pessoa.Pessoa;
import br.com.jump.pessoa.service.iface.IClienteService;
import br.com.jump.pessoa.service.iface.IPessoaService;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by macorin on 05/08/14.
 */
@Controller
@RequestMapping(value = "/cliente")
@SessionAttributes({"cliente"})
public class ClienteController extends GenericCrudController<Cliente, Long> {

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private IPessoaService pessoaService;

    @Override
    protected String[] getCamposDataTable() {
        return new String[]{
                "cliId",
                "pessoa.pesIdentificacao",
                "pessoa.pesNome"
        };
    }

    @Override
    protected IGenericService<Cliente, Long> getService() {
        return clienteService;
    }

    /**
     * sobrepondo metodo para salvar a pessoa antes de salvar o cliente.
     * @param entidade
     * @param result
     * @param request
     * @return
     */
    @Override
    public ModelAndView salvar(@ModelAttribute(value = "model") Cliente entidade, BindingResult result, HttpServletRequest request) {
        pessoaService.salvar(entidade.getPessoa());

        return super.salvar(entidade, result, request);
    }

    /**
     * metodo chamado pelo tablecrud quando selecionado o novo.
     * redireciona para a tela de search do cliente.
     *
     * @return
     */
    @RequestMapping(value = "/search.do", method = RequestMethod.GET)
    public ModelAndView searchPessoa() {
        ModelAndView modelAndView = new ModelAndView("cliente/clienteSearch");

        modelAndView.addObject("listTipoPessoa", ETipoPessoa.values());

        return modelAndView;
    }

    /**
     * verifica se existe uma pessoa com o CPF/CNPJ digitados.
     * caso não exista vai redirecionar para a tela de cadastro
     * caso exista vai buscar o cliente, se não existir vai redirecionar para a tela de cadastro
     * caso exista o cliente, redireciona para edição.
     * @param tipoPessoa
     * @param identificacao
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/search.do", method = RequestMethod.POST)
    public String searchPessoa(@RequestParam(value = "tipoPessoa") ETipoPessoa tipoPessoa,
                                     @RequestParam(value = "identificacao") String identificacao,
                                     HttpServletRequest request,
                                     ModelMap modelMap) {
        Usuario usuario = usuarioLogado(request);

        /**
         * primeiro vai procurar a pessoa pelo tipo e numero de identificacao, pois pode
         * ser que exista a pessoa vinculada a fornecedor ou outra entidade.
         */
        Pessoa pessoa = pessoaService.buscarPorTipoIdentificacao(usuario.getGrupoEmpresa().getGreId(),
                tipoPessoa,
                identificacao);

        Cliente cliente = null;
        String requestMapping = null;

        if (pessoa != null) {
            /**
             * se a pessoa existir vai verificar se existe o cliente.
             */
            cliente = clienteService.buscarPorPessoa(pessoa.getPesId());
        }

        if (cliente == null) {
            requestMapping = "redirect:newCliente.do";

            cliente = new Cliente();

            cliente.setPessoa(pessoa != null ? pessoa : new Pessoa());
            cliente.setDataCriacao(new LocalDateTime());
            cliente.setSituacao(ESituacao.Ativo);

            if (pessoa == null) {
                cliente.getPessoa().setPesTipoPessoa(tipoPessoa);
                cliente.getPessoa().setPesIdentificacao(identificacao);

                cliente.getPessoa().setSituacao(ESituacao.Ativo);
                cliente.getPessoa().setDataCriacao(new LocalDateTime());
                cliente.getPessoa().setGrupoEmpresa(usuario.getGrupoEmpresa());
            }
        } else {
            requestMapping = "redirect:editCliente.do";
        }

        cliente.setDataAlteracao(new LocalDateTime());
        cliente.getPessoa().setDataAlteracao(new LocalDateTime());

        /**
         * isso é feito apenas para mudar a url de seach para new ou edit do cliente.
         */
        modelMap.addAttribute(cliente);
        return requestMapping;
    }

    @RequestMapping(value = "/newCliente.do", method = RequestMethod.GET)
    public ModelAndView newCliente(@ModelAttribute(value = "cliente") Cliente cliente) {
        ModelAndView view = new ModelAndView("cliente/clienteForm");
        view.addObject("model", cliente);

        return view;
    }

    @RequestMapping(value = "/editCliente.do")
    public ModelAndView editCliente(@ModelAttribute(value = "cliente") Cliente cliente) {
        ModelAndView view = new ModelAndView("cliente/clienteForm");
        view.getModel().put("model", cliente);

        return view;
    }
}
