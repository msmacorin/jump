package br.com.jump.core.interceptor;

import br.com.jump.model.admin.ParametroSistema;
import br.com.jump.model.admin.Usuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import br.com.jump.model.admin.Menu;

public abstract class MenuPersonalizadoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        Usuario usuarioLogado = (Usuario) request.getAttribute(ParametroSistema.USUARIO_LOGADO);
        if (modelAndView != null && usuarioLogado != null) {
            modelAndView.addObject("listaMenu", construirMenu(usuarioLogado));
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }

    public abstract List<Menu> construirMenu(Usuario usuarioLogado);
}
