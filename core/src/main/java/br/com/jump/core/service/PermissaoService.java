package br.com.jump.core.service;

import br.com.jump.core.service.iface.IPermissaoService;
import br.com.jump.model.admin.Usuario;
import org.springframework.stereotype.Service;

@Service(value = "permissaoService")
public class PermissaoService implements IPermissaoService {

    @Override
    public boolean temPermissaoModulo(Usuario usuario, String modulo) {
        if (modulo.equalsIgnoreCase("search")) {
            if (!usuario.getUsuNome().equalsIgnoreCase("administrador")) {
                 return false;
            }
        }

        return true;
    }

    @Override
    public boolean temPermissaoPrograma(Usuario usuario, String programa) {
        return true;
    }
}
