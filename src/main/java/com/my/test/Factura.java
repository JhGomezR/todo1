/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my.test;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "factura")
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByFacturaId", query = "SELECT f FROM Factura f WHERE f.facturaId = :facturaId"),
    @NamedQuery(name = "Factura.findByFFecha", query = "SELECT f FROM Factura f WHERE f.fFecha = :fFecha"),
    @NamedQuery(name = "Factura.findByFOtp", query = "SELECT f FROM Factura f WHERE f.fOtp = :fOtp")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "factura_id")
    private Integer facturaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "f_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFecha;
    @Size(max = 6)
    @Column(name = "f_otp")
    private String fOtp;
    @JoinColumn(name = "f_cliente_fk", referencedColumnName = "cliente_id")
    @ManyToOne(optional = false)
    private Cliente fClienteFk;
    @JoinColumn(name = "f_vendedor_fk", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false)
    private Usuario fVendedorFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dfFacturaFk")
    private Collection<DetalleFactura> detalleFacturaCollection;

    public Factura() {
    }

    public Factura(Integer facturaId) {
        this.facturaId = facturaId;
    }

    public Factura(Integer facturaId, Date fFecha) {
        this.facturaId = facturaId;
        this.fFecha = fFecha;
    }

    public Integer getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Integer facturaId) {
        this.facturaId = facturaId;
    }

    public Date getFFecha() {
        return fFecha;
    }

    public void setFFecha(Date fFecha) {
        this.fFecha = fFecha;
    }

    public String getFOtp() {
        return fOtp;
    }

    public void setFOtp(String fOtp) {
        this.fOtp = fOtp;
    }

    public Cliente getFClienteFk() {
        return fClienteFk;
    }

    public void setFClienteFk(Cliente fClienteFk) {
        this.fClienteFk = fClienteFk;
    }

    public Usuario getFVendedorFk() {
        return fVendedorFk;
    }

    public void setFVendedorFk(Usuario fVendedorFk) {
        this.fVendedorFk = fVendedorFk;
    }

    public Collection<DetalleFactura> getDetalleFacturaCollection() {
        return detalleFacturaCollection;
    }

    public void setDetalleFacturaCollection(Collection<DetalleFactura> detalleFacturaCollection) {
        this.detalleFacturaCollection = detalleFacturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaId != null ? facturaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.facturaId == null && other.facturaId != null) || (this.facturaId != null && !this.facturaId.equals(other.facturaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.my.test.Factura[ facturaId=" + facturaId + " ]";
    }
    
}
