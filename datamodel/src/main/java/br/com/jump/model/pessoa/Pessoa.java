package br.com.jump.model.pessoa;

import br.com.jump.model.admin.GrupoEmpresa;
import br.com.jump.model.enums.ESituacao;
import br.com.jump.model.enums.ETipoPessoa;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pessoa", schema = "pessoa")
@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", allocationSize = 1)
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 5864846825628638163L;

    @Id
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_pessoa")
    private Long pesId;

    @Column(name = "tipo_pessoa")
    @Type(type = "br.com.jump.core.usertype.TipoPessoaUserType")
    private ETipoPessoa pesTipoPessoa;

    @Column(name = "nome")
    private String pesNome;

    @Column(name = "nome_reduzido")
    private String pesNomeReduzido;

    @Column(name = "identificacao")
    private String pesIdentificacao;

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

    @OneToMany(mappedBy = "pessoa")
    private Set<PessoaEndereco> listPessoaEndereco;

    public Pessoa() {
    }

    public Long getPesId() {
        return pesId;
    }

    public void setPesId(Long pesId) {
        this.pesId = pesId;
    }

    public ETipoPessoa getPesTipoPessoa() {
        return pesTipoPessoa;
    }

    public void setPesTipoPessoa(ETipoPessoa pesTipoPessoa) {
        this.pesTipoPessoa = pesTipoPessoa;
    }

    public String getPesIdentificacao() {
        return pesIdentificacao;
    }

    public void setPesIdentificacao(String pesIdentificacao) {
        this.pesIdentificacao = pesIdentificacao;
    }

    public String getPesNome() {
        return pesNome;
    }

    public void setPesNome(String pesNome) {
        this.pesNome = pesNome;
    }

    public String getPesNomeReduzido() {
        return pesNomeReduzido;
    }

    public void setPesNomeReduzido(String pesNomeReduzido) {
        this.pesNomeReduzido = pesNomeReduzido;
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

    public Set<PessoaEndereco> getListPessoaEndereco() {
        return listPessoaEndereco;
    }

    public void setListPessoaEndereco(Set<PessoaEndereco> listPessoaEndereco) {
        this.listPessoaEndereco = listPessoaEndereco;
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
