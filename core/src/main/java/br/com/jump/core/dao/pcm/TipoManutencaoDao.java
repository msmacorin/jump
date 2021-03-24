/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.core.dao.pcm;

import br.com.jump.core.dao.JumpDao;
import br.com.jump.core.dao.pcm.iface.ITipoManutencaoDao;
import br.com.jump.model.pcm.TipoManutencao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author macorin
 */
@Transactional("jump")
@Repository(value = "tipoManutencaoDao")
public class TipoManutencaoDao extends JumpDao<TipoManutencao, Long> implements ITipoManutencaoDao {
}
