package br.com.jump.scaffold.interceptor;

import java.util.ArrayList;
import java.util.List;

import br.com.jump.core.interceptor.MenuPersonalizadoInterceptor;
import br.com.jump.model.admin.Menu;
import br.com.jump.model.admin.Usuario;

public class MenuScaffoldInterceptor extends MenuPersonalizadoInterceptor {

    @Override
    public List<Menu> construirMenu(Usuario usuarioLogado) {
        List<Menu> listaMenu = new ArrayList<Menu>();
        return listaMenu;
    }
}
