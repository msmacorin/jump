package br.com.jump.pcm.controller;

import br.com.jump.core.annotation.AcessoAdministradorPermitido;
import br.com.jump.core.annotation.AcessoAnonimoPermitido;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ModuloController {

    @AcessoAdministradorPermitido
	@RequestMapping(value="/index.do", method=RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {
		return new ModelAndView("index");
	}

	@AcessoAnonimoPermitido
    @AcessoAdministradorPermitido
	@RequestMapping(value="/acessoNegado.do", method=RequestMethod.GET)
	public ModelAndView accessDenied(HttpServletRequest request) {
		return new ModelAndView("acessoNegado");
		
	}

    @RequestMapping(value = "/404.do")
    public ModelAndView handle404() {
        return new ModelAndView("404");
    }
}
