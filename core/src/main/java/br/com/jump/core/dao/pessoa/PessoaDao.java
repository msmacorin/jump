package br.com.jump.core.dao.pessoa;

import br.com.jump.core.dao.JumpDao;
import br.com.jump.core.dao.pessoa.iface.IPessoaDao;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.enums.ETipoPessoa;
import br.com.jump.model.pessoa.Cliente;
import br.com.jump.model.pessoa.Pessoa;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by macorin on 12/08/14.
 */
@Transactional("jump")
@Repository(value = "pessoaDao")
public class PessoaDao extends JumpDao<Pessoa, Long> implements IPessoaDao {

    @Override
    public Pessoa findByTipoIdentificacao(Long idGrupoEmpresa, ETipoPessoa tipoPessoa, String identificacao) {
        StringBuilder query = new StringBuilder();

        query.append("FROM Pessoa p ");
        query.append("  JOIN p.grupoEmpresa g ");
        query.append("WHERE g.greId = :greId ");
        query.append("AND p.pesTipoPessoa = :pesTipoPessoa ");
        query.append("AND p.pesIdentificacao = :pesIdentificacao ");
        query.append("AND p.situacao = :situacao");

        Map<String, Object> param = new HashMap<String, Object>();

        param.put("greId", idGrupoEmpresa);
        param.put("pesTipoPessoa", tipoPessoa);
        param.put("pesIdentificacao", identificacao);
        param.put("situacao", ESituacao.Ativo);

        return findByHQL(query.toString(), param);
    }
}
