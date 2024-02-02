package com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.service;

import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository.model.Hotel;

import java.util.List;

public interface IHotelService {
    Hotel buscar(Integer id);
    List<Hotel> buscarHotelsInnerJoin();
    List<Hotel> buscarHotelsRightJoin();
    List<Hotel> buscarHotelsLeftJoin();
    List<Hotel> buscarHotelsFullJoin();
    //InnerJoin
    List<Hotel> buscarHotelsWithHabitaciones();
    List<Hotel> buscarHotelByNameWithHabitaciones(String nombre);
    //LeftJoin
    List<Hotel> buscarAllHotels();
    List<Hotel> buscarAllHotelsWithPool();
    //RightJoin
    List<Hotel> buscarAllHabitaciones();
    List<Hotel> buscarAllHabitacionesByDireccion(String direccion);
    //fullJoin
    List<Hotel> buscarHabitacionesConVistaPiscina();
    List<Hotel> buscarHabitacionesSinVistaPiscina();
    //fetch
    List<Hotel> buscarHotelConPiscina();
    List<Hotel> buscarHotelSinPiscina();
    void guardar(Hotel hotel);
    void actualizar (Hotel hotel);
    void eliminar(Integer id);

}
