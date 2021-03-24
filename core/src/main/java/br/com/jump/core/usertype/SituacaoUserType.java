/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.core.usertype;

import br.com.jump.model.enums.ESituacao;
import in.macor.core.usertype.EnumUserType;

/**
 *
 * @author macorin
 */
public class SituacaoUserType extends EnumUserType<Integer> {

    @Override
    protected Object getValue(Integer codigo) {
        return ESituacao.findByCodigo(codigo);
    }

    @Override
    public Class<ESituacao> returnedClass() {
        return ESituacao.class;
    }
    
}
