package br.com.jump.pessoa.service.iface;

import br.com.jump.core.service.iface.IGenericService;
import br.com.jump.model.enums.ETipoPessoa;
import br.com.jump.model.pessoa.Cliente;

/**
 * Created by macorin on 05/08/14.
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

    public Cliente buscarPorPessoa(Long idPessoa);
}
