/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.core.dao.pcm;

import br.com.jump.core.dao.JumpDao;
import br.com.jump.core.dao.pcm.iface.IPrioridadeDao;
import br.com.jump.model.pcm.Prioridade;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author macorin
 */
@Transactional("jump")
@Repository(value = "prioridadeDao")
public class PrioridadeDao extends JumpDao<Prioridade, Long> implements IPrioridadeDao {
}
