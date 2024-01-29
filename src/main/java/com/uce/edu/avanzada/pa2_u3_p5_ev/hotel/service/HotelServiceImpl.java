package com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.service;

import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository.IHotelRepository;
import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements IHotelService {
    @Autowired
    private IHotelRepository iHotelRepository;
    @Override
    public Hotel buscar(Integer id) {
        return this.iHotelRepository.seleccionar(id);
    }

    @Override
    public List<Hotel> buscarHotelsInnerJoin() {
        return this.iHotelRepository.selectHotelsInnerJoin();
    }

    @Override
    public List<Hotel> buscarHotelsRightJoin() {
        return this.iHotelRepository.selectHotelsRightJoin();
    }

    @Override
    public List<Hotel> buscarHotelsLeftJoin() {
        return this.iHotelRepository.selectHotelsLeftJoin();
    }

    @Override
    public List<Hotel> buscarHotelsFullJoin() {
        return this.iHotelRepository.selectHotelsFullJoin();
    }

    @Override
    public void guardar(Hotel hotel) {
        this.iHotelRepository.insertar(hotel);
    }

    @Override
    public void actualizar(Hotel hotel) {
        this.iHotelRepository.actualizar(hotel);
    }

    @Override
    public void eliminar(Integer id) {
        this.iHotelRepository.eliminar(id);
    }
}
