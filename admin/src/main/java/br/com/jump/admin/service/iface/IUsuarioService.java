package br.com.jump.admin.service.iface;

import br.com.jump.model.admin.Usuario;
import br.com.jump.core.service.iface.IGenericService;

public interface IUsuarioService extends IGenericService<Usuario, Long> {

    public Usuario buscarPorEmail(String email);

    public Usuario buscarPorUsuario(String usuario);
}
