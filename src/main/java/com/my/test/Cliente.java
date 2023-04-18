/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my.test;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author JhonGomez
 */
@Entity
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByClienteId", query = "SELECT c FROM Cliente c WHERE c.clienteId = :clienteId"),
    @NamedQuery(name = "Cliente.findByCNombre", query = "SELECT c FROM Cliente c WHERE c.cNombre = :cNombre"),
    @NamedQuery(name = "Cliente.findByCApellido", query = "SELECT c FROM Cliente c WHERE c.cApellido = :cApellido"),
    @NamedQuery(name = "Cliente.findByCDireccion", query = "SELECT c FROM Cliente c WHERE c.cDireccion = :cDireccion"),
    @NamedQuery(name = "Cliente.findByCDocumentoTipo", query = "SELECT c FROM Cliente c WHERE c.cDocumentoTipo = :cDocumentoTipo"),
    @NamedQuery(name = "Cliente.findByCNumDocumento", query = "SELECT c FROM Cliente c WHERE c.cNumDocumento = :cNumDocumento")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cliente_id")
    private Integer clienteId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "c_nombre")
    private String cNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "c_apellido")
    private String cApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "c_direccion")
    private String cDireccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_documento_tipo")
    private int cDocumentoTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "c_num_documento")
    private String cNumDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fClienteFk")
    private Collection<Factura> facturaCollection;

    public Cliente() {
    }

    public Cliente(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Cliente(Integer clienteId, String cNombre, String cApellido, String cDireccion, int cDocumentoTipo, String cNumDocumento) {
        this.clienteId = clienteId;
        this.cNombre = cNombre;
        this.cApellido = cApellido;
        this.cDireccion = cDireccion;
        this.cDocumentoTipo = cDocumentoTipo;
        this.cNumDocumento = cNumDocumento;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getCNombre() {
        return cNombre;
    }

    public void setCNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    public String getCApellido() {
        return cApellido;
    }

    public void setCApellido(String cApellido) {
        this.cApellido = cApellido;
    }

    public String getCDireccion() {
        return cDireccion;
    }

    public void setCDireccion(String cDireccion) {
        this.cDireccion = cDireccion;
    }

    public int getCDocumentoTipo() {
        return cDocumentoTipo;
    }

    public void setCDocumentoTipo(int cDocumentoTipo) {
        this.cDocumentoTipo = cDocumentoTipo;
    }

    public String getCNumDocumento() {
        return cNumDocumento;
    }

    public void setCNumDocumento(String cNumDocumento) {
        this.cNumDocumento = cNumDocumento;
    }

    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteId != null ? clienteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.clienteId == null && other.clienteId != null) || (this.clienteId != null && !this.clienteId.equals(other.clienteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.my.test.Cliente[ clienteId=" + clienteId + " ]";
    }
    
}
