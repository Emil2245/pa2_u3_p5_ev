package com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.service;

import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository.model.Hotel;

import java.util.List;

public interface IHotelService {
    Hotel buscar(Integer id);
    List<Hotel> buscarHotelsInnerJoin();
    List<Hotel> buscarHotelsRightJoin();
    List<Hotel> buscarHotelsLeftJoin();
    List<Hotel> buscarHotelsFullJoin();
    void guardar(Hotel hotel);
    void actualizar (Hotel hotel);
    void eliminar(Integer id);

}
