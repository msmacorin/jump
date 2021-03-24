package br.com.jump.admin.interceptor;

import br.com.jump.core.interceptor.MenuPersonalizadoInterceptor;
import br.com.jump.model.admin.ItemMenu;
import br.com.jump.model.admin.Menu;
import br.com.jump.model.admin.Usuario;
import java.util.ArrayList;
import java.util.List;

public class MenuAdminInterceptor extends MenuPersonalizadoInterceptor {

    @Override
    public List<Menu> construirMenu(Usuario usuarioLogado) {
        List<Menu> listaMenu = new ArrayList<Menu>();

        Menu manutencao = new Menu();
        
        manutencao.setIcon("icon-tasks");
        manutencao.setLabel("menu.manutencao");
        manutencao.setItensMenu(new ArrayList<ItemMenu>());
        
        manutencao.getItensMenu().add(new ItemMenu("menu.adm.manutencao.usuario", "/usuario/index.do"));
        manutencao.getItensMenu().add(new ItemMenu("menu.adm.manutencao.grupoEmpresa", "/grupoEmpresa/index.do"));
        manutencao.getItensMenu().add(new ItemMenu("menu.adm.manutencao.licenca", "/licenca/index.do"));

        listaMenu.add(manutencao);
        
        return listaMenu;
    }
}
