package br.com.jump.pessoa.service;

import br.com.jump.core.dao.pessoa.iface.IPaisDao;
import br.com.jump.core.service.GenericService;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.pessoa.Pais;
import br.com.jump.pessoa.service.iface.IPaisService;
import in.macor.core.dao.iface.IGenericDao;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService extends GenericService<Pais, Long>  implements IPaisService {

    @Autowired
    private IPaisDao paisDao;

    @Override
    protected IGenericDao getDao() {
        return paisDao;
    }

    @Override
    protected boolean exclusaoVirtual() {
        return true;
    }

    @Override
    public void salvar(Pais entidade) {
        paisDao.save(entidade);
    }

    @Override
    public void deletar(Long id) {
        Pais pais = buscarPorId(id);

        pais.setSituacao(ESituacao.Excluido);
        pais.setDataAlteracao(new LocalDateTime());

        paisDao.save(pais);
    }

    @Override
    public Pais buscarPorId(Long id) {
        return paisDao.findById(id);
    }
}
