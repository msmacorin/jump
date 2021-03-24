/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.admin.service;

import br.com.jump.core.dao.admin.iface.IGrupoEmpresaDao;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.admin.GrupoEmpresa;
import br.com.jump.core.service.iface.IGrupoEmpresaService;
import br.com.jump.core.service.GenericService;
import in.macor.core.dao.iface.IGenericDao;
import in.macor.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macorin
 */
@Service
public class GrupoEmpresaService extends GenericService<GrupoEmpresa, Long> implements IGrupoEmpresaService {

    @Autowired
    private IGrupoEmpresaDao grupoEmpresaDao;

    //<editor-fold desc="Metodos abstratos">
    @Override
    @SuppressWarnings("rawtypes")
    protected IGenericDao getDao() {
        return grupoEmpresaDao;
    }

    @Override
    protected boolean exclusaoVirtual() {
        return true;
    }
    
    //</editor-fold>
    
    //<editor-fold desc="Metodos">
    @Override
    public GrupoEmpresa buscarPorId(Long id) {
        return grupoEmpresaDao.findById(id);
    }

    @Override
    public void salvar(GrupoEmpresa entidade) {
        grupoEmpresaDao.save(entidade);
    }

    @Override
    public void deletar(Long id) throws ServiceException {
        GrupoEmpresa grupoEmpresa = buscarPorId(id);
        grupoEmpresa.setSituacao(ESituacao.Excluido);

        this.salvar(grupoEmpresa);
    }
    //</editor-fold>
}
