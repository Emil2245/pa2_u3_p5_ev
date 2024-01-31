package com.uce.edu.avanzada.pa2_u3_p5_ev;

import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;


@SpringBootApplication
public class Pa2U3P5EvApplication implements CommandLineRunner {

    public static void main(String... args) {
        SpringApplication.run(Pa2U3P5EvApplication.class, args);
    }

    @Autowired
    private IFacturaService iFacturaService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("UPDATE: ");
        System.out.println(this.iFacturaService.actualizarFechas(
                LocalDateTime.of(2024,01,25,0,0,0),
                LocalDateTime.now()));
        System.out.println("------------------------------------------\nDELETE: ");
//        System.out.println(this.iFacturaService.borrarPorNumero("0002-0002"));
        System.out.println("------------------------------------------");
        this.iFacturaService.buscarFacturasDTO().forEach(System.out::println);





    }
}
