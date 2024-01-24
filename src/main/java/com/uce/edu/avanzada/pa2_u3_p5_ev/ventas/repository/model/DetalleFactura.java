package com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
@Table ( name = "detalle_factura")
public class DetalleFactura {
    @Id
    @SequenceGenerator(name = "generator_detalle_factura", allocationSize = 1,sequenceName = "seq_detalle_factura_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_detalle_factura")
    @Column (name ="defa_id")
    private Integer id;
    @Column (name ="defa_cantidad")
    private Integer cantidad;
    @Column (name ="defa_codigo_barras")
    private String codigoBarras;
    @Column (name ="defa_nombre_producto")
    private String nombreProducto;
    @ManyToOne()
    @JoinColumn(name = "defa_id_factura")
    private Factura factura;

    ////////////////////////////

    @Override
    public String toString() {
        return "DetalleFactura{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", nombreProducto='" + nombreProducto + '\'' +
                '}';
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
