package com.uce.edu.avanzada.pa2_u3_p5_ev.funcional;

@FunctionalInterface
public interface IPersonaFunction <P,O> {
    P aplicar(O arg);

}
