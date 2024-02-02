package com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository;

import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository.model.Habitacion;
import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository.model.Hotel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class HotelRepoImpl implements IHotelRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Hotel seleccionar(Integer id) {
        return this.entityManager.find(Hotel.class, id);
    }

    @Override
    public List<Hotel> selectHotelsInnerJoin() {
        TypedQuery<Hotel> query =
                this.entityManager.createQuery("select h from Hotel h join h.habitaciones ", Hotel.class);
        List<Hotel> lista = query.getResultList();
        lista.stream().forEach(hotel -> hotel.getHabitaciones().size());// bajo demanda
        return lista;
    }

    @Override
    public List<Hotel> selectHotelsRightJoin() {
        TypedQuery<Hotel> query =
                this.entityManager.createQuery("select h from Hotel h right join h.habitaciones" , Hotel.class);
        List<Hotel> lista = query.getResultList();
        lista.stream().forEach(hotel -> hotel.getHabitaciones().size());// bajo demanda
        return lista;
    }

    @Override
    public List<Hotel> selectHotelsLeftJoin() {
        TypedQuery<Hotel> query =
                this.entityManager.createQuery("select h from Hotel h left join h.habitaciones" , Hotel.class);
        List<Hotel> lista = query.getResultList();
        lista.stream().forEach(hotel -> hotel.getHabitaciones().size());// bajo demanda
        return lista;
    }

    @Override
    public List<Hotel> selectHotelsFullJoin() {
        TypedQuery<Hotel> query =
                this.entityManager.createQuery("select h from Hotel h full join h.habitaciones" , Hotel.class);
        List<Hotel> lista = query.getResultList();
        lista.forEach(hotel -> hotel.getHabitaciones().size());// bajo demanda
        return lista;
    }

    @Override
    public void insertar(Hotel hotel) {
        this.entityManager.persist(hotel);
    }

    @Override
    public void actualizar(Hotel hotel) {
        this.entityManager.merge(hotel);

    }

    @Override
    public void eliminar(Integer id) {
        Hotel hotel = this.seleccionar(id);
        this.entityManager.remove(
                hotel
        );
    }

    @Override
    public List<Hotel> selectHotelsWithHabitaciones() {
        return this.entityManager.createQuery("select h from Hotel h inner join h.habitaciones", Hotel.class)
                .getResultList();
    }

    @Override
    public List<Hotel> selectHotelByNameWithHabitaciones(String nombre) {
        return this.entityManager.createQuery("select h from Hotel h inner join h.habitaciones where h.nombre= :nombre", Hotel.class)
                .setParameter("nombre", nombre)
                .getResultList();
    }

    @Override
    public List<Hotel> selectAllHotels() {
        return this.entityManager
                .createQuery("select h from Hotel h left join h.habitaciones", Hotel.class)
                .getResultList();
    }

    @Override
    public List<Hotel> selectAllHotelsWithPool() {
        return this.entityManager
                .createQuery("select h from Hotel h left join h.habitaciones where h.tienePiscina=true", Hotel.class)
                .getResultList();
    }

    @Override
    public List<Hotel> selectAllHabitaciones() {
        return this.entityManager
                .createQuery("select h from Hotel h right join h.habitaciones", Hotel.class)
                .getResultList();
    }

    @Override
    public List<Hotel> selectAllHabitacionesByDireccion(String direccion) {
        return this.entityManager
                .createQuery("select h from Hotel h right join h.habitaciones where h.direccion=:direccion", Hotel.class)
                .setParameter("direccion",direccion)
                .getResultList();
    }

    @Override
    public List<Hotel> selectHabitacionesConVistaPiscina() {
        return this.entityManager
                .createQuery("select h from Hotel h full join h.habitaciones k where k.tieneVistaPiscina =true", Hotel.class)
                .getResultList();
    }

    @Override
    public List<Hotel> selectHabitacionesSinVistaPiscina() {
        return this.entityManager
                .createQuery("select h from Hotel h full join h.habitaciones k where k.tieneVistaPiscina =false", Hotel.class)
                .getResultList();
    }

    @Override
    public List<Hotel> selectHotelConPiscina() {
        return this.entityManager.createQuery("select y from Hotel y join fetch y.habitaciones p where y.tienePiscina ",Hotel.class)
                .getResultList();
    }

    @Override
    public List<Hotel> selectHotelSinPiscina() {
        return this.entityManager.createQuery("select y from Hotel y join fetch y.habitaciones p where y.tienePiscina ",Hotel.class)
                .getResultList();
    }
}
