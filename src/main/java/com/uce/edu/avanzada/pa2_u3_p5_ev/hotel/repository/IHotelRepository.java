package com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository;

import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository.model.Habitacion;
import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository.model.Hotel;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Factura;

import java.util.List;

public interface IHotelRepository {
    Hotel seleccionar(Integer id);
    List<Hotel> selectHotelsInnerJoin();
    List<Hotel> selectHotelsRightJoin();
    List<Hotel> selectHotelsLeftJoin();
    List<Hotel> selectHotelsFullJoin();
    void insertar(Hotel hotel);

    void actualizar(Hotel hotel);

    void eliminar(Integer id);
}
