package com.uce.edu.avanzada.pa2_u3_p5_ev.funcional;

public class Ciudadano {
    private String nombre;
    private String aplellido;
    private String provincia;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAplellido() {
        return aplellido;
    }

    public void setAplellido(String aplellido) {
        this.aplellido = aplellido;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Ciudadano{" +
                "nombre='" + nombre + '\'' +
                ", aplellido='" + aplellido + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
