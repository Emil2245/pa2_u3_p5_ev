package com.uce.edu.avanzada.pa2_u3_p5_ev.funcional;

public class PersonaSupplierImpl implements IPersonaSupplier<String>{

    @Override
    public String getid() {
        String cedula = "934857938";
        cedula=cedula+"provincia";
        return cedula;
    }
}
