package br.com.jump.core.interceptor;

import br.com.jump.core.annotation.AcessoAdministradorPermitido;
import br.com.jump.core.annotation.AcessoAnonimoPermitido;
import br.com.jump.core.annotation.PermissaoNecessaria;
import br.com.jump.model.admin.ParametroSistema;
import br.com.jump.model.admin.Usuario;
import br.com.jump.core.service.iface.ILoginService;
import br.com.jump.core.service.iface.IPermissaoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityAccessInterceptor implements HandlerInterceptor {

    private ILoginService loginService;

    private IPermissaoService permissaoService;

    private String modulo;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        Usuario usuarioLogado = getUsuarioLogado(request, response);
        if (usuarioLogado != null) {
            request.setAttribute(ParametroSistema.USUARIO_LOGADO, usuarioLogado);
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        AcessoAnonimoPermitido acessoAnonimo = handlerMethod.getMethod().getAnnotation(AcessoAnonimoPermitido.class);
        AcessoAdministradorPermitido acessoAdministrador = handlerMethod.getMethod().getAnnotation(AcessoAdministradorPermitido.class);
        PermissaoNecessaria permissaoNecessaria = handlerMethod.getMethod().getDeclaringClass().getAnnotation(PermissaoNecessaria.class);

        if (usuarioLogado == null) {
            if (acessoAnonimo != null) {
                return true;
            }

            StringBuilder builder = new StringBuilder();
            builder.append("/admin/login.do?redirect_url=");
            builder.append(request.getRequestURI());

            response.sendRedirect(builder.toString());
            return false;
        } else if (usuarioLogado.getUsuUsuario().equalsIgnoreCase("administrador")) {
            if (acessoAdministrador != null) {
                return true;
            } else {
                response.sendRedirect(request.getContextPath() + "/acessoNegado.do");
                return false;
            }
        } else if (StringUtils.isNotBlank(modulo) && !permissaoService.temPermissaoModulo(usuarioLogado, modulo)) {
            response.sendRedirect(request.getContextPath() + "/acessoNegado.do");
            return false;
        } else if (permissaoNecessaria != null && StringUtils.isNotBlank(permissaoNecessaria.programa())
                && !permissaoService.temPermissaoPrograma(usuarioLogado, permissaoNecessaria.programa())) {
            response.sendRedirect(request.getContextPath() + "/acessoNegado.do");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws IOException {
        if (modelAndView != null) {
            Usuario usuarioLogado = (Usuario) request.getAttribute(ParametroSistema.USUARIO_LOGADO);
            modelAndView.addObject(ParametroSistema.USUARIO_LOGADO, usuarioLogado);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }

    public void setLoginService(ILoginService loginService) {
        this.loginService = loginService;
    }

    public void setPermissaoService(IPermissaoService permissaoService) {
        this.permissaoService = permissaoService;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    private Usuario getUsuarioLogado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Usuario usuarioLogado = null;
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals(ParametroSistema.NOME_COOKIE)) {
                    String authToken = cookie.getValue();
                    usuarioLogado = loginService.findByToken(authToken);
                    break;
                }
            }
        }
        return usuarioLogado;
    }
}
