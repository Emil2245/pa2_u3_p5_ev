package com.uce.edu.avanzada.pa2_u3_p5_ev;


import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Cliente;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.service.IClienteService;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Pa2U3P5EvApplication implements CommandLineRunner {

    public static void main(String... args) {
        SpringApplication.run(Pa2U3P5EvApplication.class, args);
    }

    @Autowired
    private IFacturaService iFacturaService;

    @Autowired
    private IClienteService iClienteService;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("--------Nombre Hilo: "+Thread.currentThread().getName());
//        for (int i = 1; i <= 100; i++) {
//            Cliente cliente = new Cliente();
//            cliente.setNombre("CN" + i);
//            cliente.setApellido("CA" + i);
//
//            iClienteService.guardar(cliente);
//        }
        List<Cliente> listaCliente = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Cliente cliente = new Cliente();
            cliente.setNombre("CN" + i);
            cliente.setApellido("CA" + i);

            listaCliente.add(cliente);
        }
        long tiempoInicial = System.currentTimeMillis();
//        listaCliente.stream().forEach(iClienteService::guardar);
        long tiempoFinal = System.currentTimeMillis();
//

        tiempoInicial = System.currentTimeMillis();
        listaCliente.parallelStream().forEach(this.iClienteService::guardar);
        tiempoFinal = System.currentTimeMillis();

        System.out.println("Tiempo Transcurrido: "+(tiempoFinal - tiempoInicial));





    }
}
