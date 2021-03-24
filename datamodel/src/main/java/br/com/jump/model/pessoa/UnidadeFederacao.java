package br.com.jump.model.pessoa;

import br.com.jump.model.admin.GrupoEmpresa;
import br.com.jump.model.enums.ESituacao;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "unidade_federacao", schema = "pessoa")
@SequenceGenerator(name = "seq_unidade_federacao", sequenceName = "seq_unidade_federacao", allocationSize = 1)
public class UnidadeFederacao implements Serializable {
    private static final long serialVersionUID = -5370985014280314145L;

    @Id
    @Column(name = "id_uf")
    @GeneratedValue(generator = "seq_unidade_federacao", strategy = GenerationType.SEQUENCE)
    private Long unfId;

    @Column(name = "nome")
    private String unfNome;

    @Column(name = "sigla")
    private String unfSigla;

    @Column(name = "codigo_ibge")
    private Integer unfCodigoIbge;

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

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

    public UnidadeFederacao() {
    }

    public Long getUnfId() {
        return unfId;
    }

    public void setUnfId(Long unfId) {
        this.unfId = unfId;
    }

    public String getUnfSigla() {
        return unfSigla;
    }

    public void setUnfSigla(String unfSigla) {
        this.unfSigla = unfSigla;
    }

    public String getUnfNome() {
        return unfNome;
    }

    public void setUnfNome(String unfNome) {
        this.unfNome = unfNome;
    }

    public Integer getUnfCodigoIbge() {
        return unfCodigoIbge;
    }

    public void setUnfCodigoIbge(Integer unfCodigoIbge) {
        this.unfCodigoIbge = unfCodigoIbge;
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

    public GrupoEmpresa getGrupoEmpresa() {
        return grupoEmpresa;
    }

    public void setGrupoEmpresa(GrupoEmpresa grupoEmpresa) {
        this.grupoEmpresa = grupoEmpresa;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
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
