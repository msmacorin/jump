package br.com.jump.pessoa.interceptor;

import java.util.ArrayList;
import java.util.List;

import br.com.jump.core.interceptor.MenuPersonalizadoInterceptor;
import br.com.jump.model.admin.ItemMenu;
import br.com.jump.model.admin.Menu;
import br.com.jump.model.admin.Usuario;

public class MenuPessoaInterceptor extends MenuPersonalizadoInterceptor {

    @Override
    public List<Menu> construirMenu(Usuario usuarioLogado) {
        List<Menu> listaMenu = new ArrayList<Menu>();

        Menu manutencao = new Menu();

        manutencao.setIcon("icon-tasks");
        manutencao.setLabel("menu.manutencao");

        manutencao.addItemMenu(new ItemMenu("menu.pessoa.manutencao.cliente", "/cliente/index.do"));
        manutencao.addItemMenu(new ItemMenu("menu.pessoa.manutencao.fornecedor", "/fornecedor/index.do"));
        manutencao.addItemMenu(new ItemMenu("menu.pessoa.manutencao.localidade", "/localidade/index.do"));
        manutencao.addItemMenu(new ItemMenu("menu.pessoa.manutencao.pais", "/pais/index.do"));
        manutencao.addItemMenu(new ItemMenu("menu.pessoa.manutencao.tipoEndereco", "/tipoEndereco/index.do"));
        manutencao.addItemMenu(new ItemMenu("menu.pessoa.manutencao.unidadeFederacao", "/unidadeFederacao/index.do"));

        listaMenu.add(manutencao);

        return listaMenu;
    }
}
