package br.com.jump.core.dao.admin;

import br.com.jump.core.dao.JumpDao;
import br.com.jump.core.dao.admin.iface.IUsuarioDao;
import br.com.jump.model.enums.ESimNao;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.admin.Usuario;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Transactional("jump")
@Repository(value = "usuarioDao")
public class UsuarioDao extends JumpDao<Usuario, Long> implements IUsuarioDao {

    private static final String FIND_BY_USUARIO = "FROM Usuario u WHERE u.usuUsuario = :usuUsuario";

    private static final String FIND_BY_EMAIL = "FROM Usuario u WHERE u.usuEmail = :usuEmail";

    @Override
    public Usuario findByUsuario(String usuario) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("usuUsuario", usuario);
        return findByHQL(FIND_BY_USUARIO, param);
    }

    @Override
    public Usuario findByEmail(String email) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("usuEmail", email);
        return findByHQL(FIND_BY_EMAIL, param);
    }

    @Override
    public Usuario criateAdminUser() {
        Usuario admin = new Usuario();
        admin.setUsuAlterarSenha(ESimNao.N);
        admin.setUsuEmail("administrador@jump.com");
        admin.setUsuNome("Administrador");
        admin.setUsuUsuario("administrador");

        // a senha do administrador é dinamicamente criada utilizando a data do dia.
        admin.setUsuSenha("administrador");

        admin.setSituacao(ESituacao.Ativo);
        admin.setDataCriacao(new LocalDateTime());
        admin.setDataAlteracao(new LocalDateTime());

        save(admin);

        return admin;
    }
}
