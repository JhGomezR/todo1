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
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsuarioId", query = "SELECT u FROM Usuario u WHERE u.usuarioId = :usuarioId"),
    @NamedQuery(name = "Usuario.findByUNombre", query = "SELECT u FROM Usuario u WHERE u.uNombre = :uNombre"),
    @NamedQuery(name = "Usuario.findByUApellido", query = "SELECT u FROM Usuario u WHERE u.uApellido = :uApellido"),
    @NamedQuery(name = "Usuario.findByUDocumento", query = "SELECT u FROM Usuario u WHERE u.uDocumento = :uDocumento")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuario_id")
    private Integer usuarioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "u_nombre")
    private String uNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "u_apellido")
    private String uApellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "u_documento")
    private int uDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fVendedorFk")
    private Collection<Factura> facturaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eUsuarioFk")
    private Collection<Entrada> entradaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sUsuarioFk")
    private Collection<Salida> salidaCollection;

    public Usuario() {
    }

    public Usuario(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Usuario(Integer usuarioId, String uNombre, String uApellido, int uDocumento) {
        this.usuarioId = usuarioId;
        this.uNombre = uNombre;
        this.uApellido = uApellido;
        this.uDocumento = uDocumento;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUNombre() {
        return uNombre;
    }

    public void setUNombre(String uNombre) {
        this.uNombre = uNombre;
    }

    public String getUApellido() {
        return uApellido;
    }

    public void setUApellido(String uApellido) {
        this.uApellido = uApellido;
    }

    public int getUDocumento() {
        return uDocumento;
    }

    public void setUDocumento(int uDocumento) {
        this.uDocumento = uDocumento;
    }

    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    public Collection<Entrada> getEntradaCollection() {
        return entradaCollection;
    }

    public void setEntradaCollection(Collection<Entrada> entradaCollection) {
        this.entradaCollection = entradaCollection;
    }

    public Collection<Salida> getSalidaCollection() {
        return salidaCollection;
    }

    public void setSalidaCollection(Collection<Salida> salidaCollection) {
        this.salidaCollection = salidaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.my.test.Usuario[ usuarioId=" + usuarioId + " ]";
    }
    
}
