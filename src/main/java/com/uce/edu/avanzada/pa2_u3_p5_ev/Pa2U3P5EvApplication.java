package com.uce.edu.avanzada.pa2_u3_p5_ev;

import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.service.IClienteService;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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


//        this.iFacturaService.pruebaSupports();
        try{
            this.iFacturaService.pruebaNever();
        }catch (Exception ignored){}


    }
}
