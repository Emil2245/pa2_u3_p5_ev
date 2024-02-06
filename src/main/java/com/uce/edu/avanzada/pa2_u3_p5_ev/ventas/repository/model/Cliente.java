package com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @SequenceGenerator(name = "generator_cliente", allocationSize = 1,sequenceName = "seq_cliente_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_cliente")
    @Column(name = "cli_id")
    private Integer id;
    @Column(name = "cli_nombre")
    private String nombre;
    @Column(name = "cli_apellido")
    private String apellido;

    ////////////////

    public Cliente() {
    }

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
