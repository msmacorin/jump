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
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *
 * @author macorin
 */
@Entity
@Table(name = "prioridade", schema = "service")
@SequenceGenerator(name = "seq_prioridade", sequenceName = "seq_prioridade", allocationSize = 1)
public class Prioridade implements Serializable {

    private static final long serialVersionUID = -7989113202487427757L;

    @Id
    @Column(name = "id_prioridade")
    @GeneratedValue(generator = "seq_prioridade", strategy = GenerationType.SEQUENCE)
    private Long prId;
    
    @Column(name = "descricao")
    private String prDescricao;

    @Column(name = "tempo_resolucao")
    private Long prTempoResolucao;

    @Column(name = "ativo")
    @Enumerated(EnumType.STRING)
    private ESimNao prAtivo;
    
    @ManyToOne
    @JoinColumn(name = "fk_grupo_empresa")
    private GrupoEmpresa grupoEmpresa;

    public Prioridade() {
    }

    public Long getPrId() {
        return prId;
    }

    public void setPrId(Long prId) {
        this.prId = prId;
    }

    public String getPrDescricao() {
        return prDescricao;
    }

    public void setPrDescricao(String prDescricao) {
        this.prDescricao = prDescricao;
    }

    public Long getPrTempoResolucao() {
        return prTempoResolucao;
    }

    public void setPrTempoResolucao(Long prTempoResolucao) {
        this.prTempoResolucao = prTempoResolucao;
    }

    public ESimNao getPrAtivo() {
        return prAtivo;
    }

    public void setPrAtivo(ESimNao prAtivo) {
        this.prAtivo = prAtivo;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
