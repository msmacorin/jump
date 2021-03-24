package br.com.jump.core.dao.pessoa.iface;

import br.com.jump.model.enums.ETipoPessoa;
import br.com.jump.model.pessoa.Pessoa;
import in.macor.core.dao.iface.IGenericDao;

/**
 * Created by macorin on 12/08/14.
 */
public interface IPessoaDao extends IGenericDao<Pessoa, Long> {

    public Pessoa findByTipoIdentificacao(Long idGrupoEmpresa, ETipoPessoa tipoPessoa, String identificacao);
}
