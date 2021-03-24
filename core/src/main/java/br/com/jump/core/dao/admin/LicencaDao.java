package br.com.jump.core.dao.admin;

import br.com.jump.core.dao.JumpDao;
import br.com.jump.core.dao.admin.iface.ILicencaDao;
import br.com.jump.model.admin.Licenca;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional("jump")
@Repository(value = "licencaDao")
public class LicencaDao extends JumpDao<Licenca, Long> implements ILicencaDao {
}
