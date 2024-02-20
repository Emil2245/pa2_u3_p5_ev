
package com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.service;

import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.IClienteRepo;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.concurrent.TimeUnit;

@Service
public class ClienteImplService implements IClienteService {
    @Autowired
    private IClienteRepo iClienteRepo;

    @Override
    public void guardar(Cliente cliente) {

        System.out.println("--------Nombre Hilo: "+Thread.currentThread().getName());

        this.iClienteRepo.insertar(cliente);
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException ignored) {

        }
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
