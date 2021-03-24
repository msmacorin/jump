package br.com.jump.model.pessoa;

import br.com.jump.model.enums.ESimNao;
import br.com.jump.model.enums.ESituacao;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pessoa_endereco", schema = "pessoa")
@SequenceGenerator(name = "seq_pessoa_endereco", sequenceName = "seq_pessoa_endereco", allocationSize = 1)
public class PessoaEndereco implements Serializable {

    private static final long serialVersionUID = -1776520793540277188L;

    @Id
    @Column(name = "id_pessoa_endereco")
    @GeneratedValue(generator = "seq_pessoa_endereco", strategy = GenerationType.SEQUENCE)
    private Long peeId;

    @Column(name = "logradouro")
    private String peeLogradouro;

    @Column(name = "numero")
    private String peeNumero;

    @Column(name = "bairro")
    private String peeBairro;

    @Column(name = "complemento")
    private String peeComplemento;

    @Column(name = "principal")
    @Type(type = "br.com.jump.core.usertype.SimNaoUserType")
    private ESimNao peePrincipal;

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
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "id_cep_localidade")
    private CepLocalidade cepLocalidade;

    @ManyToOne
    @JoinColumn(name = "id_tipo_endereco")
    private TipoEndereco tipoEndereco;

    public PessoaEndereco() {
    }

    public Long getPeeId() {
        return peeId;
    }

    public void setPeeId(Long peeId) {
        this.peeId = peeId;
    }

    public String getPeeLogradouro() {
        return peeLogradouro;
    }

    public void setPeeLogradouro(String peeLogradouro) {
        this.peeLogradouro = peeLogradouro;
    }

    public String getPeeNumero() {
        return peeNumero;
    }

    public void setPeeNumero(String peeNumero) {
        this.peeNumero = peeNumero;
    }

    public String getPeeBairro() {
        return peeBairro;
    }

    public void setPeeBairro(String peeBairro) {
        this.peeBairro = peeBairro;
    }

    public String getPeeComplemento() {
        return peeComplemento;
    }

    public void setPeeComplemento(String peeComplemento) {
        this.peeComplemento = peeComplemento;
    }

    public ESimNao getPeePrincipal() {
        return peePrincipal;
    }

    public void setPeePrincipal(ESimNao peePrincipal) {
        this.peePrincipal = peePrincipal;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public CepLocalidade getCepLocalidade() {
        return cepLocalidade;
    }

    public void setCepLocalidade(CepLocalidade cepLocalidade) {
        this.cepLocalidade = cepLocalidade;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
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
