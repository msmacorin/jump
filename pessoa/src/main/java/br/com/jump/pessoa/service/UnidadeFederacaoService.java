package br.com.jump.pessoa.service;

import br.com.jump.core.dao.pessoa.iface.IUnidadeFederacaoDao;
import br.com.jump.core.service.GenericService;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.pessoa.UnidadeFederacao;
import br.com.jump.pessoa.service.iface.IUnidadeFederacaoService;
import in.macor.core.dao.iface.IGenericDao;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadeFederacaoService extends GenericService<UnidadeFederacao, Long> implements IUnidadeFederacaoService {

    @Autowired
    private IUnidadeFederacaoDao unidadeFederacaoDao;

    @Override
    protected IGenericDao getDao() {
        return unidadeFederacaoDao;
    }

    @Override
    protected boolean exclusaoVirtual() {
        return true;
    }

    @Override
    public void salvar(UnidadeFederacao entidade) {
        unidadeFederacaoDao.save(entidade);
    }

    @Override
    public void deletar(Long id) {
        UnidadeFederacao unidadeFederacao = buscarPorId(id);

        unidadeFederacao.setSituacao(ESituacao.Ativo);
        unidadeFederacao.setDataAlteracao(new LocalDateTime());

        unidadeFederacaoDao.save(unidadeFederacao);
    }

    @Override
    public UnidadeFederacao buscarPorId(Long id) {
        return unidadeFederacaoDao.findById(id);
    }
}
