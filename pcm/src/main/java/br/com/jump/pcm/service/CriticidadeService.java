/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.pcm.service;

import br.com.jump.core.dao.pcm.iface.ICriticidadeDao;
import br.com.jump.core.service.GenericService;
import br.com.jump.model.pcm.Criticidade;
import br.com.jump.pcm.service.iface.ICriticidadeService;
import in.macor.core.dao.iface.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macorin
 */
@Service
public class CriticidadeService extends GenericService<Criticidade, Long> implements ICriticidadeService {

    @Autowired
    private ICriticidadeDao criticidadeDao;

    //<editor-fold desc="Metodos abstratos">
    @Override
    protected IGenericDao getDao() {
        return criticidadeDao;
    }

    @Override
    protected boolean exclusaoVirtual() {
        return false;
    }

    //</editor-fold>
    
    //<editor-fold desc="Metodos">
    @Override
    public void salvar(Criticidade entidade) {
        criticidadeDao.save(entidade);
    }

    @Override
    public void deletar(Long id) {
        criticidadeDao.delete(buscarPorId(id));
    }

    @Override
    public Criticidade buscarPorId(Long id) {
        return criticidadeDao.findById(id);
    }
    //</editor-fold>
}
