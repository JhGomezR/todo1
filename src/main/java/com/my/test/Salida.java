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

/**
 *
 * @author JhonGomez
 */
@Entity
@Table(name = "salida")
@NamedQueries({
    @NamedQuery(name = "Salida.findAll", query = "SELECT s FROM Salida s"),
    @NamedQuery(name = "Salida.findBySalidaId", query = "SELECT s FROM Salida s WHERE s.salidaId = :salidaId"),
    @NamedQuery(name = "Salida.findBySFecha", query = "SELECT s FROM Salida s WHERE s.sFecha = :sFecha"),
    @NamedQuery(name = "Salida.findBySCantidad", query = "SELECT s FROM Salida s WHERE s.sCantidad = :sCantidad")})
public class Salida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "salida_id")
    private Integer salidaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "s_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "s_cantidad")
    private int sCantidad;
    @JoinColumn(name = "s_usuario_fk", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false)
    private Usuario sUsuarioFk;
    @JoinColumn(name = "s_producto_fk", referencedColumnName = "producto_id")
    @ManyToOne(optional = false)
    private Producto sProductoFk;

    public Salida() {
    }

    public Salida(Integer salidaId) {
        this.salidaId = salidaId;
    }

    public Salida(Integer salidaId, Date sFecha, int sCantidad) {
        this.salidaId = salidaId;
        this.sFecha = sFecha;
        this.sCantidad = sCantidad;
    }

    public Integer getSalidaId() {
        return salidaId;
    }

    public void setSalidaId(Integer salidaId) {
        this.salidaId = salidaId;
    }

    public Date getSFecha() {
        return sFecha;
    }

    public void setSFecha(Date sFecha) {
        this.sFecha = sFecha;
    }

    public int getSCantidad() {
        return sCantidad;
    }

    public void setSCantidad(int sCantidad) {
        this.sCantidad = sCantidad;
    }

    public Usuario getSUsuarioFk() {
        return sUsuarioFk;
    }

    public void setSUsuarioFk(Usuario sUsuarioFk) {
        this.sUsuarioFk = sUsuarioFk;
    }

    public Producto getSProductoFk() {
        return sProductoFk;
    }

    public void setSProductoFk(Producto sProductoFk) {
        this.sProductoFk = sProductoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salidaId != null ? salidaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salida)) {
            return false;
        }
        Salida other = (Salida) object;
        if ((this.salidaId == null && other.salidaId != null) || (this.salidaId != null && !this.salidaId.equals(other.salidaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.my.test.Salida[ salidaId=" + salidaId + " ]";
    }
    
}
