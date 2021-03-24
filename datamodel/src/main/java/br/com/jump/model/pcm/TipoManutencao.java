/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.model.pcm;

import br.com.jump.model.enums.ESimNao;
import br.com.jump.model.admin.GrupoEmpresa;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *
 * @author macorin
 */
@Entity
@Table(name = "tipo_manutencao", schema = "service")
@SequenceGenerator(name = "seq_tipomanutencao", sequenceName = "seq_tipomanutencao", allocationSize = 1)
public class TipoManutencao implements Serializable {

    private static final long serialVersionUID = -4944593821336775134L;
    
    @Id
    @Column(name = "id_tipo_manutencao")
    @GeneratedValue(generator = "seq_tipomanutencao", strategy = GenerationType.SEQUENCE)
    private Long tmId;
    
    @Column(name = "descricao")
    private String tmDescricao;
    
    @Column(name = "ativo")
    @Enumerated(EnumType.STRING)
    private ESimNao tmAtivo;
    
    @ManyToOne
    @JoinColumn(name = "fk_grupo_empresa")
    private GrupoEmpresa grupoEmpresa;

    public TipoManutencao() {
    }

    public Long getTmId() {
        return tmId;
    }

    public void setTmId(Long tmId) {
        this.tmId = tmId;
    }

    public String getTmDescricao() {
        return tmDescricao;
    }

    public void setTmDescricao(String tmDescricao) {
        this.tmDescricao = tmDescricao;
    }

    public ESimNao getTmAtivo() {
        return tmAtivo;
    }

    public void setTmAtivo(ESimNao tmAtivo) {
        this.tmAtivo = tmAtivo;
    }

    public GrupoEmpresa getGrupoEmpresa() {
        return grupoEmpresa;
    }

    public void setGrupoEmpresa(GrupoEmpresa grupoEmpresa) {
        this.grupoEmpresa = grupoEmpresa;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
