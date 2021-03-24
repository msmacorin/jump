package br.com.jump.admin.service;

import br.com.jump.admin.service.iface.ILicencaService;
import br.com.jump.core.dao.admin.iface.ILicencaDao;
import br.com.jump.core.service.GenericService;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.admin.Licenca;
import in.macor.core.dao.iface.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LicencaService extends GenericService<Licenca, Long> implements ILicencaService {

    @Autowired
    private ILicencaDao licencaDao;

    @Override
    protected IGenericDao getDao() {
        return licencaDao;
    }

    @Override
    protected boolean exclusaoVirtual() {
        return true;
    }

    @Override
    public void salvar(Licenca licenca) {
        licencaDao.save(licenca);
    }

    @Override
    public void deletar(Long id) {
        Licenca licenca = buscarPorId(id);

        licenca.setSituacao(ESituacao.Excluido);
        salvar(licenca);
    }

    @Override
    public Licenca buscarPorId(Long id) {
        return licencaDao.findById(id);
    }
}
