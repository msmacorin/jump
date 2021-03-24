/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.model.estoque;

import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.admin.GrupoEmpresa;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

/**
 *
 * @author macorin
 */
@Entity
@Table(name = "genero_produto", schema = "estoque")
@SequenceGenerator(name = "seq_genero_produto", sequenceName = "seq_genero_produto", allocationSize = 1)
public class GeneroProduto implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "seq_genero_produto", strategy = GenerationType.SEQUENCE)
    private Long gpId;

    @Column(name = "descricao")
    private String gpDescricao;

    @ManyToOne
    @JoinColumn(name = "fk_grupo_empresa")
    private GrupoEmpresa grupoEmpresa;
            
    @Column(name = "situation")
    @Type(type = "br.com.jump.core.usertype.SituacaoUserType")
    private ESituacao situation;

    @Column(name = "creation")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate creation;

    @Column(name = "changed")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate changed;
    
    public GeneroProduto() {
    }

    public Long getGpId() {
        return gpId;
    }

    public void setGpId(Long gpId) {
        this.gpId = gpId;
    }

    public String getGpDescricao() {
        return gpDescricao;
    }

    public void setGpDescricao(String gpDescricao) {
        this.gpDescricao = gpDescricao;
    }

    public ESituacao getSituation() {
        return situation;
    }

    public void setSituation(ESituacao situation) {
        this.situation = situation;
    }

    public LocalDate getCreation() {
        return creation;
    }

    public void setCreation(LocalDate creation) {
        this.creation = creation;
    }

    public LocalDate getChanged() {
        return changed;
    }

    public void setChanged(LocalDate changed) {
        this.changed = changed;
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
