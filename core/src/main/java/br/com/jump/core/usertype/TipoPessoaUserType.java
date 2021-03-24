package br.com.jump.core.usertype;

import br.com.jump.model.enums.ETipoPessoa;
import in.macor.core.usertype.EnumUserType;

public class TipoPessoaUserType extends EnumUserType<String> {
    @Override
    protected Object getValue(String s) {
        return ETipoPessoa.findByCodigo(s);
    }

    @Override
    public Class returnedClass() {
        return ETipoPessoa.class;
    }
}
