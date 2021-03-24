package br.com.jump.core.dao.pessoa;

import br.com.jump.core.dao.JumpDao;
import br.com.jump.core.dao.pessoa.iface.IPaisDao;
import br.com.jump.model.pessoa.Pais;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional("jump")
@Repository(value = "paisDao")
public class PaisDao extends JumpDao<Pais, Long>  implements IPaisDao {
}
