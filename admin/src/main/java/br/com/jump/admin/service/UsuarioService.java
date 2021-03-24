package br.com.jump.admin.service;

import br.com.jump.core.dao.admin.iface.IUsuarioDao;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.admin.Usuario;
import br.com.jump.admin.service.iface.IUsuarioService;
import br.com.jump.core.service.GenericService;
import in.macor.core.dao.iface.IGenericDao;
import in.macor.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends GenericService<Usuario, Long> implements IUsuarioService {

    @Autowired
    private IUsuarioDao usuarioDao;
    
    @Override
    @SuppressWarnings("rawtypes")
    protected IGenericDao getDao() {
        return usuarioDao;
    }

    @Override
    protected boolean exclusaoVirtual() {
        return true;
    }

    @Override
    public void salvar(Usuario entidade) {
        if (entidade.getGrupoEmpresa() == null) {
            throw new ServiceException("usuario.grupoEmpresa.requerido");
        }
        
        usuarioDao.save(entidade);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioDao.findById(id);
    }
    
    @Override
    public void deletar(Long id) throws ServiceException {
        Usuario usuario = buscarPorId(id);
        usuario.setSituacao(ESituacao.Excluido);
        
        this.salvar(usuario);
    }
    
    @Override
    public Usuario buscarPorEmail(String email) {
        return usuarioDao.findByEmail(email);
    }

    @Override
    public Usuario buscarPorUsuario(String usuario) {
        return usuarioDao.findByUsuario(usuario);
    }

    private boolean emailDuplicado(Usuario usuario) {
        Usuario usuarioBd = buscarPorEmail(usuario.getUsuEmail());
        
        if (usuarioBd != null && 
            (!usuarioBd.getUsuId().equals(usuario.getUsuId())
            || usuarioBd.getSituacao().equals(ESituacao.Ativo))) {
            return true;
        }
        
        return false;
    }
    
    private boolean usuarioDuplicado(Usuario usuario) {
        Usuario usuarioBd = buscarPorUsuario(usuario.getUsuUsuario());
        
        if (usuarioBd != null &&
            (!usuarioBd.getUsuId().equals(usuario.getUsuId())
            || usuarioBd.getSituacao().equals(ESituacao.Ativo))) {
            return true;
        }
        
        return false;
    }
}
