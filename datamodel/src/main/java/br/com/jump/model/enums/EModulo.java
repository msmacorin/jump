package br.com.jump.model.enums;

import com.sun.crypto.provider.DESCipher;
import in.macor.commons.iface.IEnums;

/**
 * Created by macorin on 30/06/14.
 */
public enum EModulo implements IEnums<String> {

    ADMIN("ADMIN", "enumeration.modulo.admin"),
    ESTOQUE("ESTOQUE", "enumeration.modulo.estoque"),
    PCM("PCM", "enumeration.modulo.pcm"),
    PESSOA("PESSOA", "enumeration.modulo.pessoa"),
    CONTABILIDADE("CONTABILIDADE", "enumeration.modulo.contabilidade"),
    TIMESHEET("TIMESHEET", "enumeration.modulo.timesheet");

    private String codigo;
    private String descricao;

    EModulo(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}
