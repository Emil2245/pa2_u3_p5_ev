package com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository;

import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ClienteImplRepo implements IClienteRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(value = Transactional.TxType.REQUIRED)
    @Override
    public void insertar(Cliente cliente) {
        this.entityManager.persist(cliente);
    }
}
