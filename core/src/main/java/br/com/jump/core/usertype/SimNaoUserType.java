package br.com.jump.core.usertype;

import br.com.jump.model.enums.ESimNao;
import in.macor.core.usertype.EnumUserType;

public class SimNaoUserType extends EnumUserType<String> {
    @Override
    protected Object getValue(String s) {
        return ESimNao.findByCodigo(s);
    }

    @Override
    public Class returnedClass() {
        return ESimNao.class;
    }
}
