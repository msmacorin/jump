package br.com.jump.core.dao.admin;

import br.com.jump.core.dao.JumpDao;
import br.com.jump.core.dao.admin.iface.ILoginTokenDao;
import br.com.jump.model.admin.LoginToken;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Transactional("jump")
@Repository(value="loginTokenDao")
public class LoginTokenDao extends JumpDao<LoginToken, Long> implements ILoginTokenDao {

    private static final String FIND_BY_TOKEN = "FROM LoginToken l WHERE l.lotToken = :lotToken";

    private static final String FIND_BY_USUARIO = "FROM LoginToken l WHERE l.usuario.usuId = :usuId";

    @Override
    public LoginToken findByToken(String token) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("lotToken", token);
        return findByHQL(FIND_BY_TOKEN, params);
    }

    @Override
    public LoginToken findByUsuario(Long usuarioId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("usuId", usuarioId);
        return findByHQL(FIND_BY_USUARIO, params);
    }
}
