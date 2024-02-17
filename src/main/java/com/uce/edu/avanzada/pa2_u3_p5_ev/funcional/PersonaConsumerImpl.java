package com.uce.edu.avanzada.pa2_u3_p5_ev.funcional;

public class PersonaConsumerImpl implements IPersonaConsumer<String>{

    @Override
    public void accept(String arg) {
        System.out.println("Se inserta en la BD: " + arg);
    }
}
