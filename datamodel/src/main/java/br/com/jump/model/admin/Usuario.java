/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.model.admin;

import br.com.jump.model.enums.ESimNao;
import br.com.jump.model.enums.ESituacao;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author macorin
 */
@Entity
@Table(name = "usuario", schema = "admin")
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1)
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1246305392366359540L;

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(generator = "seq_usuario", strategy = GenerationType.SEQUENCE)
    private Long usuId;

    @Column(name = "nome")
    private String usuNome;

    @Column(name = "usuario")
    private String usuUsuario;

    @Column(name = "senha")
    private String usuSenha;

    @Column(name = "email")
    private String usuEmail;

    @Column(name = "alterar_senha")
    @Enumerated(EnumType.STRING)
    private ESimNao usuAlterarSenha;

    @ManyToOne
    @JoinColumn(name = "id_grupo_empresa")
    private GrupoEmpresa grupoEmpresa;

    @Column(name = "situacao")
    @Type(type = "br.com.jump.core.usertype.SituacaoUserType")
    private ESituacao situacao;

    @Column(name = "data_criacao")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime dataCriacao;

    @Column(name = "data_alteracao")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime dataAlteracao;

    public Usuario() {
    }

    public Long getUsuId() {
        return usuId;
    }

    public void setUsuId(Long usuId) {
        this.usuId = usuId;
    }

    public String getUsuNome() {
        return usuNome;
    }

    public void setUsuNome(String usuNome) {
        this.usuNome = usuNome;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuSenha() {
        return usuSenha;
    }

    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }

    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    public ESimNao getUsuAlterarSenha() {
        return usuAlterarSenha;
    }

    public void setUsuAlterarSenha(ESimNao usuAlterarSenha) {
        this.usuAlterarSenha = usuAlterarSenha;
    }

    public GrupoEmpresa getGrupoEmpresa() {
        return grupoEmpresa;
    }

    public void setGrupoEmpresa(GrupoEmpresa grupoEmpresa) {
        this.grupoEmpresa = grupoEmpresa;
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
