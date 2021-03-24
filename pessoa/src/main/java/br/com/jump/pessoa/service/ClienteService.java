package br.com.jump.pessoa.service;

import br.com.jump.core.dao.pessoa.iface.IClienteDao;
import br.com.jump.core.service.GenericService;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.enums.ETipoPessoa;
import br.com.jump.model.pessoa.Cliente;
import br.com.jump.pessoa.service.iface.IClienteService;
import in.macor.core.dao.iface.IGenericDao;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by macorin on 05/08/14.
 */
@Service
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    @Autowired
    private IClienteDao clienteDao;

    @Override
    protected IGenericDao getDao() {
        return clienteDao;
    }

    @Override
    protected boolean exclusaoVirtual() {
        return true;
    }

    @Override
    public void salvar(Cliente entidade) {
        clienteDao.save(entidade);
    }

    @Override
    public void deletar(Long id) {
        Cliente cliente = buscarPorId(id);
        cliente.setSituacao(ESituacao.Excluido);
        cliente.setDataAlteracao(new LocalDateTime());

        salvar(cliente);
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteDao.findById(id);
    }

    @Override
    public Cliente buscarPorPessoa(Long idPessoa) {
        return clienteDao.findByPessoa(idPessoa);
    }
}
