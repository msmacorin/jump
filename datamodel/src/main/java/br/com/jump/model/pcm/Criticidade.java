/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.model.pcm;

import br.com.jump.model.enums.ESimNao;
import br.com.jump.model.admin.GrupoEmpresa;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *
 * @author macorin
 */
@Entity
@Table(name = "criticidade", schema = "service")
@SequenceGenerator(name = "seq_criticidade", sequenceName = "seq_criticidade", allocationSize = 1)
public class Criticidade implements Serializable {

    private static final long serialVersionUID = -3015164115064194810L;

    @Id
    @Column(name = "id_criticidade")
    @GeneratedValue(generator = "seq_criticidade", strategy = GenerationType.SEQUENCE)
    private Long crId;

    @Column(name = "descricao")
    private String crDescricao;

    @Column(name = "faixa_inicio")
    private Long crFaixaInicio;

    @Column(name = "faixa_fim")
    private Long crFaixaFim;

    @Column(name = "ativo")
    @Enumerated(EnumType.STRING)
    private ESimNao crAtivo;

    @ManyToOne
    @JoinColumn(name = "fk_grupo_empresa")
    private GrupoEmpresa grupoEmpresa;

    public Criticidade() {
    }

    public Long getCrId() {
        return crId;
    }

    public void setCrId(Long crId) {
        this.crId = crId;
    }

    public String getCrDescricao() {
        return crDescricao;
    }

    public void setCrDescricao(String crDescricao) {
        this.crDescricao = crDescricao;
    }

    public Long getCrFaixaInicio() {
        return crFaixaInicio;
    }

    public void setCrFaixaInicio(Long crFaixaInicio) {
        this.crFaixaInicio = crFaixaInicio;
    }

    public Long getCrFaixaFim() {
        return crFaixaFim;
    }

    public void setCrFaixaFim(Long crFaixaFim) {
        this.crFaixaFim = crFaixaFim;
    }

    public ESimNao getCrAtivo() {
        return crAtivo;
    }

    public void setCrAtivo(ESimNao crAtivo) {
        this.crAtivo = crAtivo;
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
}
