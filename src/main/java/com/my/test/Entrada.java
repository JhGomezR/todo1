/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my.test;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author JhonGomez
 */
@Entity
@Table(name = "entrada")
@NamedQueries({ 
    @NamedQuery(name = "Entrada.findAll", query = "SELECT e FROM Entrada e"),
    @NamedQuery(name = "Entrada.findByEntradaId", query = "SELECT e FROM Entrada e WHERE e.entradaId = :entradaId"),
    @NamedQuery(name = "Entrada.findByEFecha", query = "SELECT e FROM Entrada e WHERE e.eFecha = :eFecha"),
    @NamedQuery(name = "Entrada.findByEProveedor", query = "SELECT e FROM Entrada e WHERE e.eProveedor = :eProveedor"),
    @NamedQuery(name = "Entrada.findByEFactura", query = "SELECT e FROM Entrada e WHERE e.eFactura = :eFactura"),
    @NamedQuery(name = "Entrada.findByECantidad", query = "SELECT e FROM Entrada e WHERE e.eCantidad = :eCantidad")})
public class Entrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "entrada_id")
    private Integer entradaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "e_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "e_proveedor")
    private String eProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "e_factura")
    private String eFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "e_cantidad")
    private int eCantidad;
    @JoinColumn(name = "e_usuario_fk", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false)
    private Usuario eUsuarioFk;
    @JoinColumn(name = "e_producto_fk", referencedColumnName = "producto_id")
    @ManyToOne(optional = false)
    private Producto eProductoFk;

    public Entrada() {
    }

    public Entrada(Integer entradaId) {
        this.entradaId = entradaId;
    }

    public Entrada(Integer entradaId, Date eFecha, String eProveedor, String eFactura, int eCantidad) {
        this.entradaId = entradaId;
        this.eFecha = eFecha;
        this.eProveedor = eProveedor;
        this.eFactura = eFactura;
        this.eCantidad = eCantidad;
    }

    public Integer getEntradaId() {
        return entradaId;
    }

    public void setEntradaId(Integer entradaId) {
        this.entradaId = entradaId;
    }

    public Date getEFecha() {
        return eFecha;
    }

    public void setEFecha(Date eFecha) {
        this.eFecha = eFecha;
    }

    public String getEProveedor() {
        return eProveedor;
    }

    public void setEProveedor(String eProveedor) {
        this.eProveedor = eProveedor;
    }

    public String getEFactura() {
        return eFactura;
    }

    public void setEFactura(String eFactura) {
        this.eFactura = eFactura;
    }

    public int getECantidad() {
        return eCantidad;
    }

    public void setECantidad(int eCantidad) {
        this.eCantidad = eCantidad;
    }

    public Usuario getEUsuarioFk() {
        return eUsuarioFk;
    }

    public void setEUsuarioFk(Usuario eUsuarioFk) {
        this.eUsuarioFk = eUsuarioFk;
    }

    public Producto getEProductoFk() {
        return eProductoFk;
    }

    public void setEProductoFk(Producto eProductoFk) {
        this.eProductoFk = eProductoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entradaId != null ? entradaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrada)) {
            return false;
        }
        Entrada other = (Entrada) object;
        if ((this.entradaId == null && other.entradaId != null) || (this.entradaId != null && !this.entradaId.equals(other.entradaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.my.test.Entrada[ entradaId=" + entradaId + " ]";
    }
    
}
