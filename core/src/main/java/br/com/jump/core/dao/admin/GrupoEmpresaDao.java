/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.core.dao.admin;

import br.com.jump.core.dao.JumpDao;
import br.com.jump.core.dao.admin.iface.IGrupoEmpresaDao;
import br.com.jump.model.admin.GrupoEmpresa;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author macorin
 */
@Transactional("jump")
@Repository(value = "grupoEmpresaDao")
public class GrupoEmpresaDao extends JumpDao<GrupoEmpresa, Long> implements IGrupoEmpresaDao {
}
