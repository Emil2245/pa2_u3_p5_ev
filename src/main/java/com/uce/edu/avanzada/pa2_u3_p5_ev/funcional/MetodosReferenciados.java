package com.uce.edu.avanzada.pa2_u3_p5_ev.funcional;

public class MetodosReferenciados {
    public String obtenerId() {
        String cedula = "934857938";
        cedula=cedula+"Referenciado";
        return cedula;
    }
    public void procesar(String cadena){
        System.out.println(cadena);
        System.out.println("Se proceso la cadena");
    }
    public boolean evaluar(String cadena){
        return "Emil".contains(cadena);
    }
    public boolean evaluar(Integer integer){
        return 8==integer;
    }
    public Ciudadano cambiar(Empleado empleado){
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setNombre(empleado.getNombreCompleto().split(" ")[0]);
        ciudadano.setAplellido(empleado.getNombreCompleto().split(" ")[1]);
        ciudadano.setAplellido("pich");
        return ciudadano;
    }
    public Empleado procesar(Empleado empleado){
        empleado.setNombreCompleto(empleado.getNombreCompleto()+ " "+ empleado.getPais());
        empleado.setPais(empleado.getPais()+" "+empleado.getNombreCompleto());
        return  empleado;

    }
}
