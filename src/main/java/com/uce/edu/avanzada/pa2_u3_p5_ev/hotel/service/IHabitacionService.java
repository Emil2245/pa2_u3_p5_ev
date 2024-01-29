package com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.service;


import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository.model.Habitacion;

public interface IHabitacionService {
    Habitacion buscar(Integer id);
    void guardar(Habitacion habitacion);
    void actualizar (Habitacion habitacion);
    void eliminar(Integer id);
}
