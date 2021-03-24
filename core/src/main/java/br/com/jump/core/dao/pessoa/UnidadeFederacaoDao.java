package br.com.jump.core.dao.pessoa;

import br.com.jump.core.dao.JumpDao;
import br.com.jump.core.dao.pessoa.iface.IUnidadeFederacaoDao;
import br.com.jump.model.pessoa.UnidadeFederacao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional("jump")
@Repository(value = "unidadeFederacaoDao")
public class UnidadeFederacaoDao extends JumpDao<UnidadeFederacao, Long>  implements IUnidadeFederacaoDao {
}
