/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my.test;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author JhonGomez
 */
@Entity
@Table(name = "detalle_factura")
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d"),
    @NamedQuery(name = "DetalleFactura.findByDfId", query = "SELECT d FROM DetalleFactura d WHERE d.dfId = :dfId"),
    @NamedQuery(name = "DetalleFactura.findByDfProductoCantidad", query = "SELECT d FROM DetalleFactura d WHERE d.dfProductoCantidad = :dfProductoCantidad")})
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "df_id")
    private Integer dfId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "df_producto_cantidad")
    private int dfProductoCantidad;
    @JoinColumn(name = "df_factura_fk", referencedColumnName = "factura_id")
    @ManyToOne(optional = false)
    private Factura dfFacturaFk;
    @JoinColumn(name = "df_producto_id", referencedColumnName = "producto_id")
    @ManyToOne(optional = false)
    private Producto dfProductoId;

    public DetalleFactura() {
    }

    public DetalleFactura(Integer dfId) {
        this.dfId = dfId;
    }

    public DetalleFactura(Integer dfId, int dfProductoCantidad) {
        this.dfId = dfId;
        this.dfProductoCantidad = dfProductoCantidad;
    }

    public Integer getDfId() {
        return dfId;
    }

    public void setDfId(Integer dfId) {
        this.dfId = dfId;
    }

    public int getDfProductoCantidad() {
        return dfProductoCantidad;
    }

    public void setDfProductoCantidad(int dfProductoCantidad) {
        this.dfProductoCantidad = dfProductoCantidad;
    }

    public Factura getDfFacturaFk() {
        return dfFacturaFk;
    }

    public void setDfFacturaFk(Factura dfFacturaFk) {
        this.dfFacturaFk = dfFacturaFk;
    }

    public Producto getDfProductoId() {
        return dfProductoId;
    }

    public void setDfProductoId(Producto dfProductoId) {
        this.dfProductoId = dfProductoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dfId != null ? dfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFactura)) {
            return false;
        }
        DetalleFactura other = (DetalleFactura) object;
        if ((this.dfId == null && other.dfId != null) || (this.dfId != null && !this.dfId.equals(other.dfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.my.test.DetalleFactura[ dfId=" + dfId + " ]";
    }
    
}
