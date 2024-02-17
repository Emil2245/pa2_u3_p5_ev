package com.uce.edu.avanzada.pa2_u3_p5_ev.funcional;

import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository.model.Habitacion;
import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository.model.Hotel;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

@FunctionalInterface
public interface IPersona {
    void caminar();
    //void comer();
    BiPredicate<Hotel, Habitacion> isNormal= (hotel, habitacion) -> true;
}
