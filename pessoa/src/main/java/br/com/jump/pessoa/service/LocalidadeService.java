package br.com.jump.pessoa.service;

import br.com.jump.core.dao.pessoa.iface.ILocalidadeDao;
import br.com.jump.core.service.GenericService;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.pessoa.Localidade;
import br.com.jump.pessoa.service.iface.ILocalidadeService;
import in.macor.core.dao.iface.IGenericDao;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalidadeService extends GenericService<Localidade, Long> implements ILocalidadeService {

    @Autowired
    private ILocalidadeDao localidadeDao;

    @Override
    protected IGenericDao getDao() {
        return localidadeDao;
    }

    @Override
    protected boolean exclusaoVirtual() {
        return true;
    }

    @Override
    public void salvar(Localidade entidade) {
        localidadeDao.save(entidade);
    }

    @Override
    public void deletar(Long id) {
        Localidade localidade = buscarPorId(id);

        localidade.setSituacao(ESituacao.Excluido);
        localidade.setDataAlteracao(new LocalDateTime());

        salvar(localidade);
    }

    @Override
    public Localidade buscarPorId(Long id) {
        return localidadeDao.findById(id);
    }
}
