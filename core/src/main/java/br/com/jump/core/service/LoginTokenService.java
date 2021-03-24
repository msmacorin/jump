package br.com.jump.core.service;

import br.com.jump.core.dao.admin.iface.ILoginTokenDao;
import br.com.jump.core.service.iface.ILoginTokenService;
import br.com.jump.model.admin.LoginToken;
import br.com.jump.model.admin.Usuario;
import in.macor.core.security.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginTokenService implements ILoginTokenService {

    @Autowired
    private ILoginTokenDao loginTokenDao;

    @Override
    @Transactional("jump")
    public String criarToken(Usuario usuario) {
        LoginToken loginToken = loginTokenDao.findByUsuario(usuario.getUsuId());
        if (loginToken == null) {
            loginToken = new LoginToken();
            loginToken.setUsuario(usuario);
        }
        loginToken.setLotToken(new RandomString(50).nextString());
        loginTokenDao.save(loginToken);
        return loginToken.getLotToken();
    }
}
