package br.com.jump.core.service;

import br.com.jump.core.dao.admin.iface.ILoginTokenDao;
import br.com.jump.core.dao.admin.iface.IUsuarioDao;
import br.com.jump.core.service.iface.ILoginService;
import br.com.jump.core.service.iface.ILoginTokenService;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.admin.LoginToken;
import br.com.jump.model.admin.ParametroSistema;
import br.com.jump.model.admin.Usuario;
import in.macor.commons.util.SecurityUtil;
import in.macor.core.exception.ServiceException;
import in.macor.core.security.PassGenerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service(value = "loginService")
public class LoginService implements ILoginService {

    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
    private ILoginTokenDao loginTokenDao;

    @Autowired
    private ILoginTokenService loginTokenService;

    @Override
    @Transactional("jump")
    public void login(Usuario usuario, HttpServletRequest request, HttpServletResponse response) {
        Usuario usuarioBD = usuarioDao.findByUsuario(usuario.getUsuUsuario());

        if (usuario.getUsuUsuario().equalsIgnoreCase("administrador")) {
            if (usuarioBD == null) {
                usuarioBD = usuarioDao.criateAdminUser();
            }
        }

        validarUsuario(usuario, usuarioBD);
        String token = loginTokenService.criarToken(usuarioBD);

        if (usuario.getUsuUsuario().equalsIgnoreCase("administrador")) {
            criarCookieAutenticacao(response, token, 60); // 1 hora.
        } else {
            criarCookieAutenticacao(response, token, null);
        }

        request.setAttribute(ParametroSistema.USUARIO_LOGADO, usuarioBD);
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute(ParametroSistema.USUARIO_LOGADO, null);

        Cookie emptyCookie = new Cookie("usuario", "");
        emptyCookie.setMaxAge(0);
        emptyCookie.setPath("/");

        response.addCookie(emptyCookie);
    }

    @Override
    public Usuario findByToken(String token) {
        LoginToken loginToken = loginTokenDao.findByToken(token);
        if (loginToken == null) {
            return null;
        }

        Usuario usuario = loginToken.getUsuario();
        return usuario;
    }

    private void validarUsuario(Usuario usuario, Usuario usuarioFromDB) {
        try {
            if (usuario.getUsuUsuario().equalsIgnoreCase("administrador")) {
                if (!usuario.getUsuSenha().equalsIgnoreCase(PassGenerated.generatedAdminPassword())) {
                    throw new ServiceException("global.erro.falha.login");
                }
            } else if (usuarioFromDB == null) {
                throw new ServiceException("global.erro.falha.login");
            } else if (!ESituacao.Ativo.equals(usuarioFromDB.getSituacao())) {
                throw new ServiceException("global.erro.usuario.inativo");
            } else {
                String senhaCriptografada = SecurityUtil.encrypt(usuario.getUsuSenha());
                if (!usuarioFromDB.getUsuSenha().equals(senhaCriptografada)) {
                    throw new ServiceException("global.erro.falha.login");
                }
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException(ex.getMessage());
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException(ex.getMessage());
        }
    }

    /**
     *
     * @param response
     * @param authToken
     * @param expiry tempo em minutos que o usuario ficara logado.
     */
    private void criarCookieAutenticacao(HttpServletResponse response, String authToken, Integer expiry) {
        Cookie cookie = new Cookie(ParametroSistema.NOME_COOKIE, authToken);
        cookie.setPath("/");

        if (expiry != null) {
            cookie.setMaxAge(expiry * 60);
        }

        response.addCookie(cookie);
    }
}