package com.uce.edu.avanzada.pa2_u3_p5_ev.funcional;

@FunctionalInterface
public interface IPersonaUnitaryOperator <Q>{
    Q modificar(Q arg);
}