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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author JhonGomez
 */
@Entity
@Table(name = "producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByProductoId", query = "SELECT p FROM Producto p WHERE p.productoId = :productoId"),
    @NamedQuery(name = "Producto.findByPNombre", query = "SELECT p FROM Producto p WHERE p.pNombre = :pNombre"),
    @NamedQuery(name = "Producto.findByPTipo", query = "SELECT p FROM Producto p WHERE p.pTipo = :pTipo"),
    @NamedQuery(name = "Producto.findByPPrecioCompra", query = "SELECT p FROM Producto p WHERE p.pPrecioCompra = :pPrecioCompra"),
    @NamedQuery(name = "Producto.findByPPrecioVenta", query = "SELECT p FROM Producto p WHERE p.pPrecioVenta = :pPrecioVenta"),
    @NamedQuery(name = "Producto.findByPCantidad", query = "SELECT p FROM Producto p WHERE p.pCantidad = :pCantidad")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "producto_id")
    private Integer productoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "p_nombre")
    private String pNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "p_tipo")
    private String pTipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_precio_compra")
    private double pPrecioCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_precio_venta")
    private double pPrecioVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_cantidad")
    private int pCantidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eProductoFk")
    private Collection<Entrada> entradaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dfProductoId")
    private Collection<DetalleFactura> detalleFacturaCollection;
    @JoinColumn(name = "p_categoria_fk", referencedColumnName = "categoria_id")
    @OneToOne(optional = false)
    private Categoria pCategoriaFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sProductoFk")
    private Collection<Salida> salidaCollection;

    public Producto() {
    }

    public Producto(Integer productoId) {
        this.productoId = productoId;
    }

    public Producto(Integer productoId, String pNombre, String pTipo, double pPrecioCompra, double pPrecioVenta, int pCantidad) {
        this.productoId = productoId;
        this.pNombre = pNombre;
        this.pTipo = pTipo;
        this.pPrecioCompra = pPrecioCompra;
        this.pPrecioVenta = pPrecioVenta;
        this.pCantidad = pCantidad;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public String getPNombre() {
        return pNombre;
    }

    public void setPNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    public String getPTipo() {
        return pTipo;
    }

    public void setPTipo(String pTipo) {
        this.pTipo = pTipo;
    }

    public double getPPrecioCompra() {
        return pPrecioCompra;
    }

    public void setPPrecioCompra(double pPrecioCompra) {
        this.pPrecioCompra = pPrecioCompra;
    }

    public double getPPrecioVenta() {
        return pPrecioVenta;
    }

    public void setPPrecioVenta(double pPrecioVenta) {
        this.pPrecioVenta = pPrecioVenta;
    }

    public int getPCantidad() {
        return pCantidad;
    }

    public void setPCantidad(int pCantidad) {
        this.pCantidad = pCantidad;
    }

    public Collection<Entrada> getEntradaCollection() {
        return entradaCollection;
    }

    public void setEntradaCollection(Collection<Entrada> entradaCollection) {
        this.entradaCollection = entradaCollection;
    }

    public Collection<DetalleFactura> getDetalleFacturaCollection() {
        return detalleFacturaCollection;
    }

    public void setDetalleFacturaCollection(Collection<DetalleFactura> detalleFacturaCollection) {
        this.detalleFacturaCollection = detalleFacturaCollection;
    }

    public Categoria getPCategoriaFk() {
        return pCategoriaFk;
    }

    public void setPCategoriaFk(Categoria pCategoriaFk) {
        this.pCategoriaFk = pCategoriaFk;
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
        hash += (productoId != null ? productoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.productoId == null && other.productoId != null) || (this.productoId != null && !this.productoId.equals(other.productoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.my.test.Producto[ productoId=" + productoId + " ]";
    }
    
}
