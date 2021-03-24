package br.com.jump.core.service.iface;

import br.com.jump.model.admin.Usuario;

public interface IPermissaoService {

    public boolean temPermissaoModulo(Usuario usuario, String modulo);

    public boolean temPermissaoPrograma(Usuario usuario, String programa);
}
