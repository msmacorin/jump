package br.com.jump.core.dao.admin.iface;

import br.com.jump.model.admin.Usuario;
import in.macor.core.dao.iface.IGenericDao;

public interface IUsuarioDao extends IGenericDao<Usuario, Long> {

    public Usuario findByUsuario(String usuario);

    public Usuario findByEmail(String email);

    public Usuario criateAdminUser();
}
