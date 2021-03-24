package br.com.jump.pessoa.service;

import br.com.jump.core.dao.pessoa.iface.IPessoaDao;
import br.com.jump.core.service.GenericService;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.enums.ETipoPessoa;
import br.com.jump.model.pessoa.Pessoa;
import br.com.jump.pessoa.service.iface.IPessoaService;
import in.macor.core.dao.iface.IGenericDao;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by macorin on 12/08/14.
 */
@Service
public class PessoaService extends GenericService<Pessoa, Long> implements IPessoaService {

    @Autowired
    private IPessoaDao pessoaDao;

    @Override
    protected IGenericDao getDao() {
        return pessoaDao;
    }

    @Override
    protected boolean exclusaoVirtual() {
        return true;
    }

    @Override
    public Pessoa buscarPorTipoIdentificacao(Long idGrupoEmpresa, ETipoPessoa tipoPessoa, String identificacao) {
        return pessoaDao.findByTipoIdentificacao(idGrupoEmpresa, tipoPessoa, identificacao);
    }

    @Override
    public void salvar(Pessoa entidade) {
        pessoaDao.save(entidade);
    }

    @Override
    public void deletar(Long id) {
        Pessoa pessoa = buscarPorId(id);

        pessoa.setDataAlteracao(new LocalDateTime());
        pessoa.setSituacao(ESituacao.Excluido);

        salvar(pessoa);
    }

    @Override
    public Pessoa buscarPorId(Long id) {
        return pessoaDao.findById(id);
    }
}
