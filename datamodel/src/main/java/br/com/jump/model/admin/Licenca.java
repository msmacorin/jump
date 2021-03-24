package br.com.jump.model.admin;

import br.com.jump.model.enums.ESituacao;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "licenca", schema = "admin")
@SequenceGenerator(name = "seq_licenca", sequenceName = "seq_licenca", allocationSize = 1)
public class Licenca implements Serializable {
    private static final long serialVersionUID = -1181810700904958521L;

    @Id
    @Column(name = "id_licenca")
    @GeneratedValue(generator = "seq_licenca", strategy = GenerationType.SEQUENCE)
    private Long licId;

    @Column(name = "inicio")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDateTime licInicio;

    @Column(name = "prazo")
    private Integer licPrazo;

    @Column(name = "validacao")
    private String licValidacao;

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

    public GrupoEmpresa getGrupoEmpresa() {
        return grupoEmpresa;
    }

    public void setGrupoEmpresa(GrupoEmpresa grupoEmpresa) {
        this.grupoEmpresa = grupoEmpresa;
    }

    public Licenca() {
    }

    public Long getLicId() {
        return licId;
    }

    public void setLicId(Long licId) {
        this.licId = licId;
    }

    public LocalDateTime getLicInicio() {
        return licInicio;
    }

    public void setLicInicio(LocalDateTime licInicio) {
        this.licInicio = licInicio;
    }

    public Integer getLicPrazo() {
        return licPrazo;
    }

    public void setLicPrazo(Integer licPrazo) {
        this.licPrazo = licPrazo;
    }

    public String getLicValidacao() {
        return licValidacao;
    }

    public void setLicValidacao(String licValidacao) {
        this.licValidacao = licValidacao;
    }

    public ESituacao getSituacao() {
        return situacao;
    }

    public void setSituacao(ESituacao situacao) {
        this.situacao = situacao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
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
