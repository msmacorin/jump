package br.com.jump.core.dao.pessoa.iface;

import br.com.jump.model.pessoa.Cliente;
import br.com.jump.model.pessoa.Fornecedor;
import in.macor.core.dao.iface.IGenericDao;

/**
 * Created by macorin on 05/08/14.
 */
public interface IFornecedorDao extends IGenericDao<Fornecedor, Long> {

    public Fornecedor findByPessoa(Long idPessoa);
}
