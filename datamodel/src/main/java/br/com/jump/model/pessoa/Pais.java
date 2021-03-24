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
@Table(name = "pais", schema = "pessoa")
@SequenceGenerator(name = "seq_pais", sequenceName = "seq_pais", allocationSize = 1)
public class Pais implements Serializable {

    private static final long serialVersionUID = 8792331594166731742L;

    @Id
    @Column(name = "id_pais")
    @GeneratedValue(generator = "seq_pais", strategy = GenerationType.SEQUENCE)
    private Long paiId;

    @Column(name = "nome")
    private String paiNome;

    @Column(name = "codigo_banco_central")
    private String paiCodigoBancoCentral;

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

    public Pais() {
    }

    public Long getPaiId() {
        return paiId;
    }

    public void setPaiId(Long paiId) {
        this.paiId = paiId;
    }

    public String getPaiNome() {
        return paiNome;
    }

    public void setPaiNome(String paiNome) {
        this.paiNome = paiNome;
    }

    public String getPaiCodigoBancoCentral() {
        return paiCodigoBancoCentral;
    }

    public void setPaiCodigoBancoCentral(String paiCodigoBancoCentral) {
        this.paiCodigoBancoCentral = paiCodigoBancoCentral;
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
