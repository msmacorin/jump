package br.com.jump.core.service.iface;

import br.com.jump.model.admin.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ILoginService {

    public void login(Usuario usuario, HttpServletRequest request, HttpServletResponse response);

    public void logout(HttpServletRequest request, HttpServletResponse response);

    public Usuario findByToken(String token);

//    public Usuario buscarUsuarioPorCookies(Cookie[] cookies);
}
