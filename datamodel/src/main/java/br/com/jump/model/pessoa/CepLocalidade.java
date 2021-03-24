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
@Table(name = "cep_localidade", schema = "pessoa")
@SequenceGenerator(name = "seq_cep_localidade", sequenceName = "seq_cep_localidade", allocationSize = 1)
public class CepLocalidade implements Serializable {

    private static final long serialVersionUID = -4384419126516377872L;

    @Id
    @GeneratedValue(generator = "seq_cep_localidade", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_cep_localidade")
    private Long celId;

    @Column(name = "cep")
    private String celCep;

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
    @JoinColumn(name = "id_localidade")
    private Localidade localidade;

    public CepLocalidade() {
    }

    public Long getCelId() {
        return celId;
    }

    public void setCelId(Long celId) {
        this.celId = celId;
    }

    public String getCelCep() {
        return celCep;
    }

    public void setCelCep(String celCep) {
        this.celCep = celCep;
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

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
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
