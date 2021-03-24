/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.model.admin;

import br.com.jump.model.enums.ESituacao;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author macorin
 */
@Entity
@Table(name = "perfil", schema = "admin")
@SequenceGenerator(name = "seq_perfil", sequenceName = "seq_perfil", allocationSize = 1)
public class Perfil implements Serializable {

    private static final long serialVersionUID = -7572929680701871088L;

    @Id
    @Column(name = "id_perfil")
    @GeneratedValue(generator = "seq_perfil", strategy = GenerationType.SEQUENCE)
    private Long perId;

    @Column(name = "nome")
    private String perNome;

    @Column(name = "nivel")
    private Integer perNivel;

    @Column(name = "situacao")
    @Type(type = "br.com.jump.core.usertype.SituacaoUserType")
    private ESituacao situacao;

    @Column(name = "data_criacao")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime dataCriacao;

    @Column(name = "data_alteracao")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime dataAlteracao;

    @ManyToOne
    @JoinColumn(name = "id_grupo_empresa")
    private GrupoEmpresa grupoEmpresa;


    public Perfil() {
    }

    public Long getPerId() {
        return perId;
    }

    public void setPerId(Long perId) {
        this.perId = perId;
    }

    public String getPerNome() {
        return perNome;
    }

    public void setPerNome(String perNome) {
        this.perNome = perNome;
    }

    public Integer getPerNivel() {
        return perNivel;
    }

    public void setPerNivel(Integer perNivel) {
        this.perNivel = perNivel;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public ESituacao getSituacao() {
        return situacao;
    }

    public void setSituacao(ESituacao situacao) {
        this.situacao = situacao;
    }

    public GrupoEmpresa getGrupoEmpresa() {
        return grupoEmpresa;
    }

    public void setGrupoEmpresa(GrupoEmpresa grupoEmpresa) {
        this.grupoEmpresa = grupoEmpresa;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
}
