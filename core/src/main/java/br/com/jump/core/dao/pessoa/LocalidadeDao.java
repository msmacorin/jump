package br.com.jump.core.dao.pessoa;

import br.com.jump.core.dao.JumpDao;
import br.com.jump.core.dao.pessoa.iface.ILocalidadeDao;
import br.com.jump.model.pessoa.Localidade;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional("jump")
@Repository(value = "localidadeDao")
public class LocalidadeDao extends JumpDao<Localidade, Long>  implements ILocalidadeDao {
}
