package com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @SequenceGenerator(name = "generator_factura", allocationSize = 1, sequenceName = "seq_factura_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_factura")
    @Column(name = "fact_id")
    private Integer id;
    @Column(name = "fact_numero")
    private String numero;
    @Column(name = "fact_fecha")
    private LocalDateTime fecha;
    @Column(name = "fact_cedula")
    private String cedula;
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DetalleFactura> detalleFacturas;

    ////////////////////get set

    public List<DetalleFactura> getDetalleFacturas() {
        return detalleFacturas;
    }

    public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
        this.detalleFacturas = detalleFacturas;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", fecha=" + fecha +
                ", cedula='" + cedula + '\'' +
                ", detalleFacturas=" + detalleFacturas +
                '}';
    }

    public Factura() {
    }

    public Factura(String numero, LocalDateTime fecha, String cedula) {
        this.numero = numero;
        this.fecha = fecha;
        this.cedula = cedula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
