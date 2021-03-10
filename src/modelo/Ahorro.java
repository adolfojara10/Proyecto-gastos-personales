/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Entity
@Table(name = "ahorro")
@NamedQueries({
    @NamedQuery(name = "Ahorro.findAll", query = "SELECT a FROM Ahorro a"),
    @NamedQuery(name = "Ahorro.findById", query = "SELECT a FROM Ahorro a WHERE a.id = :id"),
    @NamedQuery(name = "Ahorro.findByDineroEntrada", query = "SELECT a FROM Ahorro a WHERE a.dineroEntrada = :dineroEntrada")})
public class Ahorro implements Serializable {

    @Column(name = "descripcion")
    private String descripcion;

    @JoinColumn(name = "categoria_fk", referencedColumnName = "id")
    @ManyToOne
    private Categoria categoriaFk;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "dinero_entrada")
    private BigDecimal dineroEntrada;

    public Ahorro() {
    }

    public Ahorro(Integer id) {
        this.id = id;
    }

    public Ahorro(String descripcion, Categoria categoriaFk, Date fecha, Integer id, BigDecimal dineroEntrada) {
        this.descripcion = descripcion;
        this.categoriaFk = categoriaFk;
        this.fecha = fecha;
        this.id = id;
        this.dineroEntrada = dineroEntrada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getDineroEntrada() {
        return dineroEntrada;
    }

    public void setDineroEntrada(BigDecimal dineroEntrada) {
        this.dineroEntrada = dineroEntrada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ahorro)) {
            return false;
        }
        Ahorro other = (Ahorro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ahorro[ id=" + id + " ]";
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Categoria getCategoriaFk() {
        return categoriaFk;
    }

    public void setCategoriaFk(Categoria categoriaFk) {
        this.categoriaFk = categoriaFk;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
