/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.pcm.service;

import br.com.jump.core.dao.pcm.iface.IPrioridadeDao;
import br.com.jump.model.pcm.Prioridade;
import br.com.jump.pcm.service.iface.IPrioridadeService;
import br.com.jump.core.service.GenericService;
import in.macor.core.dao.iface.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macorin
 */
@Service
public class PrioridadeService extends GenericService<Prioridade, Long> implements IPrioridadeService {

    @Autowired
    private IPrioridadeDao prioridadeDao;

    //<editor-fold desc="Metodos abstratos">
    @Override
    protected IGenericDao getDao() {
        return prioridadeDao;
    }

    @Override
    protected boolean exclusaoVirtual() {
        return false;
    }
    
    //</editor-fold>
    
    //<editor-fold desc="Metodos">
    @Override
    public void salvar(Prioridade entidade) {
        prioridadeDao.save(entidade);
    }

    @Override
    public void deletar(Long id) {
        prioridadeDao.delete(buscarPorId(id));
    }

    @Override
    public Prioridade buscarPorId(Long id) {
        return prioridadeDao.findById(id);
    }
    //</editor-fold>
}
