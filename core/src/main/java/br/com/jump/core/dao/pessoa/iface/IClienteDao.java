package br.com.jump.core.dao.pessoa.iface;

import br.com.jump.model.enums.ETipoPessoa;
import br.com.jump.model.pessoa.Cliente;
import in.macor.core.dao.iface.IGenericDao;

/**
 * Created by macorin on 05/08/14.
 */
public interface IClienteDao extends IGenericDao<Cliente, Long> {

    public Cliente findByPessoa(Long idPessoa);
}
