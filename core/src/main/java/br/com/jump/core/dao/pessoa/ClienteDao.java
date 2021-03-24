package br.com.jump.core.dao.pessoa;

import br.com.jump.core.dao.JumpDao;
import br.com.jump.core.dao.pessoa.iface.IClienteDao;
import br.com.jump.model.enums.ETipoPessoa;
import br.com.jump.model.pessoa.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by macorin on 05/08/14.
 */
@Transactional("jump")
@Repository(value = "clienteDao")
public class ClienteDao extends JumpDao<Cliente, Long> implements IClienteDao {

    @Override
    public Cliente findByPessoa(Long idPessoa) {
        String query = "FROM Cliente c JOIN c.pessoa p WHERE p.pesId = :pesId";

        Map<String, Object> param = new HashMap<String, Object>();

        param.put("pesId", idPessoa);

        return findByHQL(query, param);
    }
}
