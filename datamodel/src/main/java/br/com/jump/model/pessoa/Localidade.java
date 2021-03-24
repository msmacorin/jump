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
@Table(name = "localidade", schema = "pessoa")
@SequenceGenerator(name = "seq_localidade", sequenceName = "seq_localidade", allocationSize = 1)
public class Localidade implements Serializable {
    private static final long serialVersionUID = 6724854655880441280L;

    @Id
    @Column(name = "id_localidade")
    @GeneratedValue(generator = "seq_localidade", strategy = GenerationType.SEQUENCE)
    private Long locId;

    @Column(name = "nome")
    private String locNome;

    @Column(name = "codigo_ibge")
    private Integer locCodigoIbge;

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
    @JoinColumn(name = "id_uf")
    private UnidadeFederacao unidadeFederacao;

    public Localidade() {
    }

    public Long getLocId() {
        return locId;
    }

    public void setLocId(Long locId) {
        this.locId = locId;
    }

    public String getLocNome() {
        return locNome;
    }

    public void setLocNome(String locNome) {
        this.locNome = locNome;
    }

    public Integer getLocCodigoIbge() {
        return locCodigoIbge;
    }

    public void setLocCodigoIbge(Integer locCodigoIbge) {
        this.locCodigoIbge = locCodigoIbge;
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

    public UnidadeFederacao getUnidadeFederacao() {
        return unidadeFederacao;
    }

    public void setUnidadeFederacao(UnidadeFederacao unidadeFederacao) {
        this.unidadeFederacao = unidadeFederacao;
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
