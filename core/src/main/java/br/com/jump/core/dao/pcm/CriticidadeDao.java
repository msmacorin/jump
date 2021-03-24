/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.core.dao.pcm;

import br.com.jump.core.dao.JumpDao;
import br.com.jump.core.dao.pcm.iface.ICriticidadeDao;
import br.com.jump.model.pcm.Criticidade;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author macorin
 */
@Transactional("jump")
@Repository(value = "criticidadeDao")
public class CriticidadeDao extends JumpDao<Criticidade, Long> implements ICriticidadeDao {
}
