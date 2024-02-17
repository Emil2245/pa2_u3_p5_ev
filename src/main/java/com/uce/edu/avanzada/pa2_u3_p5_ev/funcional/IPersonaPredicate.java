package com.uce.edu.avanzada.pa2_u3_p5_ev.funcional;

@FunctionalInterface
public interface IPersonaPredicate <K> {
    boolean evaluar(K arg);
}
