package br.com.jump.core.service.iface;

import br.com.jump.model.admin.Usuario;

public interface ILoginTokenService {

    public String criarToken(Usuario usuario);
}
