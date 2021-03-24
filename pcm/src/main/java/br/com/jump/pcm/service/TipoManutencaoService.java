/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.pcm.service;

import br.com.jump.core.dao.pcm.iface.ITipoManutencaoDao;
import br.com.jump.model.pcm.TipoManutencao;
import br.com.jump.pcm.service.iface.ITipoManutencaoService;
import br.com.jump.core.service.GenericService;
import in.macor.core.dao.iface.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macorin
 */
@Service
public class TipoManutencaoService extends GenericService<TipoManutencao, Long> implements ITipoManutencaoService {

    @Autowired
    private ITipoManutencaoDao tipoManutencaoDao;

    //<editor-fold desc="Metodos abstratos">
    @Override
    protected IGenericDao getDao() {
        return tipoManutencaoDao;
    }

    @Override
    protected boolean exclusaoVirtual() {
        return false;
    }

    //</editor-fold>

    //<editor-fold desc="Metodos">
    @Override
    public void salvar(TipoManutencao entidade) {
        tipoManutencaoDao.save(entidade);
    }

    @Override
    public void deletar(Long id) {
        tipoManutencaoDao.delete(buscarPorId(id));
    }

    @Override
    public TipoManutencao buscarPorId(Long id) {
        return tipoManutencaoDao.findById(id);
    }
    //</editor-fold>
}
