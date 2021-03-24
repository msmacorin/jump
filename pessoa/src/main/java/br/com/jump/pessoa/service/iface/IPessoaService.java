package br.com.jump.pessoa.service.iface;

import br.com.jump.core.service.iface.IGenericService;
import br.com.jump.model.enums.ETipoPessoa;
import br.com.jump.model.pessoa.Pessoa;

/**
 * Created by macorin on 12/08/14.
 */
public interface IPessoaService extends IGenericService<Pessoa, Long> {

    public Pessoa buscarPorTipoIdentificacao(Long idGrupoEmpresa, ETipoPessoa tipoPessoa, String identificacao);
}
