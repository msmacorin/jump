package br.com.jump.core.dao.admin.iface;

import br.com.jump.model.admin.LoginToken;
import in.macor.core.dao.iface.IGenericDao;

public interface ILoginTokenDao extends IGenericDao<LoginToken, Long> {

    public LoginToken findByToken(String token);

    public LoginToken findByUsuario(Long usuarioId);
}
