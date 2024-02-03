package com.uce.edu.avanzada.pa2_u3_p5_ev;

import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository.model.Hotel;
import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.service.IHotelService;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Cliente;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Factura;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.service.IClienteService;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.time.LocalDateTime;
import java.util.*;


@SpringBootApplication
public class Pa2U3P5EvApplication implements CommandLineRunner {

    public static void main(String... args) {
        SpringApplication.run(Pa2U3P5EvApplication.class, args);
    }

    @Autowired
    private IClienteService iClienteService;
    @Autowired
    private IFacturaService iFacturaService;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("----------------");
        this.iFacturaService.guardar(
                new Factura("84753897",LocalDateTime.now(),"98435793875"),
                new Cliente(null,"M")
        );


    }
}
