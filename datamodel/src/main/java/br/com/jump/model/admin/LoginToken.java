package br.com.jump.model.admin;

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

@Entity
@Table(name = "login_token", schema = "admin")
@SequenceGenerator(name = "seq_login_token", sequenceName = "seq_login_token", allocationSize = 1)
public class LoginToken {

    @Id
    @Column(name = "id_login_token")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_login_token")
    private Long lotId;

    @Column(name = "token", nullable = false, unique = true, length = 40)
    private String lotToken;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    public String getLotToken() {
        return lotToken;
    }

    public void setLotToken(String lotToken) {
        this.lotToken = lotToken;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
