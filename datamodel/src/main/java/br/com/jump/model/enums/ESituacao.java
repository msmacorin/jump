/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.model.enums;

import in.macor.commons.iface.IEnums;

/**
 *
 * @author macorin
 */
public enum ESituacao implements IEnums<Integer> {

    Ativo(1, "enumeration.situacao.ativo"),
    Suspenso(2, "enumeration.situacao.suspenso"),
    Excluido(3, "enumeration.situacao.excluido");
    
    public static ESituacao findByCodigo(Integer codigo){
        for (ESituacao situacao : ESituacao.values()) {
            if (situacao.getCodigo().equals(codigo)) return situacao;
        }
        
        return null;
    }
    
    private Integer codigo;
    private String descricao;

    private ESituacao(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @Override
    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}
