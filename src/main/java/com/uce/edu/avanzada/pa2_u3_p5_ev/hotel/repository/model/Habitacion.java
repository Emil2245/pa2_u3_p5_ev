package com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository.model;

import jakarta.persistence.*;

@Entity
@Table (name = "habitacion")
public class Habitacion {
    @Id
    @SequenceGenerator(name = "generator_habitacion_id", allocationSize = 1,sequenceName = "seq_habi_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_habitacion_id")
    @Column (name = "habi_id")
    private Integer id;
    @Column (name = "habi_numero")
    private String numero;
    @Column (name = "habi_clase")
    private String clase;
    @Column (name = "habi_tiene_vista_piscina")
    private Boolean tieneVistaPiscina;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "habi_id_hotel")
    private Hotel hotel;

    @Override
    public String toString() {
        return "Habitacion{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", clase='" + clase + '\'' +
                ", tieneVistaPiscina=" + tieneVistaPiscina +
                '}';
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
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

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Boolean getTieneVistaPiscina() {
        return tieneVistaPiscina;
    }

    public void setTieneVistaPiscina(Boolean tieneVistaPiscina) {
        this.tieneVistaPiscina = tieneVistaPiscina;
    }
}
