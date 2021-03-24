/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.model.estoque;

import br.com.jump.model.enums.ESimNao;
import br.com.jump.model.admin.GrupoEmpresa;
import java.io.Serializable;
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

/**
 *
 * @author macorin
 */
@Entity
@Table(name = "grupo_produto", schema = "estoque")
@SequenceGenerator(name = "seq_grupo_produto", sequenceName = "seq_grupo_produto", initialValue = 1)
public class GrupoProduto implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "seq_grupo_produto", strategy = GenerationType.SEQUENCE)
    private Long gpId;

    @Column(name = "descricao")
    private String gpDescricao;

    @Column(name = "ativo")
    private ESimNao gpAtivo;

    @ManyToOne
    @JoinColumn(name = "fk_grupo_empresa")
    private GrupoEmpresa grupoEmpresa;

    public GrupoProduto() {
    }

    public Long getGpId() {
        return gpId;
    }

    public void setGpId(Long gpId) {
        this.gpId = gpId;
    }

    public String getGpDescricao() {
        return gpDescricao;
    }

    public void setGpDescricao(String gpDescricao) {
        this.gpDescricao = gpDescricao;
    }

    public ESimNao getGpAtivo() {
        return gpAtivo;
    }

    public void setGpAtivo(ESimNao gpAtivo) {
        this.gpAtivo = gpAtivo;
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
