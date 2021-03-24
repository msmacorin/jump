package br.com.jump.pessoa.service;

import br.com.jump.core.dao.pessoa.iface.ITipoEnderecoDao;
import br.com.jump.core.service.GenericService;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.pessoa.TipoEndereco;
import br.com.jump.pessoa.service.iface.ITipoEnderecoService;
import in.macor.core.dao.iface.IGenericDao;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoEnderecoService extends GenericService<TipoEndereco, Long> implements ITipoEnderecoService {
    @Autowired
    private ITipoEnderecoDao tipoEnderecoDao;

    @Override
    protected IGenericDao getDao() {
        return tipoEnderecoDao;
    }

    @Override
    protected boolean exclusaoVirtual() {
        return true;
    }

    @Override
    public void salvar(TipoEndereco entidade) {
        tipoEnderecoDao.save(entidade);
    }

    @Override
    public void deletar(Long id) {
        TipoEndereco tipoEndereco = buscarPorId(id);

        tipoEndereco.setSituacao(ESituacao.Excluido);
        tipoEndereco.setDataAlteracao(new LocalDateTime());

        tipoEnderecoDao.save(tipoEndereco);
    }

    @Override
    public TipoEndereco buscarPorId(Long id) {
        return tipoEnderecoDao.findById(id);
    }
}
