package br.com.jump.pessoa.service;

import br.com.jump.core.dao.pessoa.iface.IFornecedorDao;
import br.com.jump.core.service.GenericService;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.pessoa.Cliente;
import br.com.jump.model.pessoa.Fornecedor;
import br.com.jump.pessoa.service.iface.IFornecedorService;
import in.macor.core.dao.iface.IGenericDao;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by macorin on 05/08/14.
 */
@Service
public class FornecedorService extends GenericService<Fornecedor, Long> implements IFornecedorService {

    @Autowired
    private IFornecedorDao fornecedorDao;

    @Override
    protected IGenericDao getDao() {
        return fornecedorDao;
    }

    @Override
    protected boolean exclusaoVirtual() {
        return true;
    }

    @Override
    public void salvar(Fornecedor entidade) {
        fornecedorDao.save(entidade);
    }

    @Override
    public void deletar(Long id) {
        Fornecedor fornecedor = buscarPorId(id);
        fornecedor.setSituacao(ESituacao.Excluido);
        fornecedor.setDataAlteracao(new LocalDateTime());

        salvar(fornecedor);
    }

    @Override
    public Fornecedor buscarPorId(Long id) {
        return fornecedorDao.findById(id);
    }

    @Override
    public Fornecedor buscarPorPessoa(Long idPessoa) {
        return fornecedorDao.findByPessoa(idPessoa);
    }
}
