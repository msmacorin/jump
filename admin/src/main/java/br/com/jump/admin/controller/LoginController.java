package br.com.jump.admin.controller;

import br.com.jump.core.annotation.AcessoAnonimoPermitido;
import br.com.jump.model.admin.ParametroSistema;
import br.com.jump.model.admin.Usuario;
import br.com.jump.core.service.iface.ILoginService;
import in.macor.commons.util.MessageUtil;
import in.macor.commons.util.StringUtil;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.macor.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @AcessoAnonimoPermitido
    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public ModelAndView loginForm(@RequestParam(value = "redirect_url", required = false) String redirectUrl,
                                  HttpServletRequest request,
                                  HttpServletResponse response) throws IOException {

        Usuario usuario = (Usuario) request.getAttribute(ParametroSistema.USUARIO_LOGADO);

        ModelAndView modelAndView = null;
        if (usuario == null) {
            modelAndView = new ModelAndView("login");
            modelAndView.addObject("usuario", new Usuario());
            modelAndView.addObject("redirectUrl", redirectUrl);
        } else {
            modelAndView = new ModelAndView("index");
        }

        return modelAndView;
    }

    @AcessoAnonimoPermitido
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute(value = "usuario") Usuario usuario,
                              @RequestParam(value = "redirect_url", required = false) String redirectUrl,
                              HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        try {
            loginService.login(usuario, request, response);
            if (StringUtil.empty(redirectUrl)) {
                return new ModelAndView("index");
            } else {
                response.sendRedirect(redirectUrl);
                return null;
            }
        } catch (ServiceException e) {
            ModelAndView view = loginForm(redirectUrl, request, response);
            view.addObject("erroLogin", e.getMessageKey());
            return view;
        }
    }

    @AcessoAnonimoPermitido
    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    public ModelAndView logout(@RequestParam(value = "redirect_url", required = false) String redirectUrl,
                               HttpServletRequest request,
                               HttpServletResponse response) throws IOException {
        try {
            loginService.logout(request, response);
            return loginForm(redirectUrl, request, response);
        } catch (ServiceException e) {
            ModelAndView view = new ModelAndView("index");
            view.addObject(MessageUtil.ERRO, e.getMessageKey());
            return view;
        }
    }
}
