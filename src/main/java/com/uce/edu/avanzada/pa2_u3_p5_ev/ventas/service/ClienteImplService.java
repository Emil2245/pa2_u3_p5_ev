
package com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.service;

import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.IClienteRepo;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class ClienteImplService implements IClienteService {
    @Autowired
    private IClienteRepo iClienteRepo;

    @Override
    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public void guardar(Cliente cliente) {
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        this.iClienteRepo.insertar(cliente);
    }
    @Override
    @Transactional(value = Transactional.TxType.SUPPORTS)
    public void pruebaSupports() {
        System.out.println("Un metodo supports");
        System.out.println("Prueba supports Cliente: "+TransactionSynchronizationManager.isActualTransactionActive());
    }


    @Override
    @Transactional(value = Transactional.TxType.NEVER)
    public void pruebaNever() {
        System.out.println("Un metodo never");
        System.out.println("Prueba never Cliente: "+TransactionSynchronizationManager.isActualTransactionActive());

    }
}
