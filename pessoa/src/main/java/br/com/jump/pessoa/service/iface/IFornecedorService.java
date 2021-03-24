package br.com.jump.pessoa.service.iface;

import br.com.jump.core.service.iface.IGenericService;
import br.com.jump.model.pessoa.Fornecedor;

/**
 * Created by macorin on 05/08/14.
 */
public interface IFornecedorService extends IGenericService<Fornecedor, Long> {

    public Fornecedor buscarPorPessoa(Long idPessoa);
}
