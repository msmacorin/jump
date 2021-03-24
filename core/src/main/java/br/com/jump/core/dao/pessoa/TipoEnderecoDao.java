package br.com.jump.core.dao.pessoa;

import br.com.jump.core.dao.JumpDao;
import br.com.jump.core.dao.pessoa.iface.ITipoEnderecoDao;
import br.com.jump.model.pessoa.TipoEndereco;
import in.macor.core.dao.GenericDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional("jump")
@Repository(value = "tipoEnderecoDao")
public class TipoEnderecoDao extends JumpDao<TipoEndereco, Long> implements ITipoEnderecoDao {
}
