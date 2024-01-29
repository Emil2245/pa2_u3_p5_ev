package com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository;

import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository.model.Habitacion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class HabitacionRepoImpl implements IHabitacionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Habitacion seleccionar(Integer id) {
        return this.entityManager.find(Habitacion.class, id);

    }

    @Override
    public void insertar(Habitacion habitacion) {
        this.entityManager.persist(habitacion);
    }

    @Override
    public void actualizar(Habitacion habitacion) {
        this.entityManager.merge(habitacion);
    }

    @Override
    public void eliminar(Integer id) {
        Habitacion habitacion = this.seleccionar(id);
        this.entityManager.remove(
                habitacion
        );
    }
}
