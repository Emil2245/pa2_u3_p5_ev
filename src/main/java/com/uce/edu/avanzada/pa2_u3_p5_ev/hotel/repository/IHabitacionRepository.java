package com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository;

import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository.model.Habitacion;

public interface IHabitacionRepository {
    Habitacion seleccionar(Integer id);
    void insertar(Habitacion habitacion);
    void actualizar (Habitacion habitacion);
    void eliminar(Integer id);
}
