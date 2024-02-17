package com.uce.edu.avanzada.pa2_u3_p5_ev;


import com.uce.edu.avanzada.pa2_u3_p5_ev.editorial.repository.model.Autor;
import com.uce.edu.avanzada.pa2_u3_p5_ev.editorial.repository.model.Libro;
import com.uce.edu.avanzada.pa2_u3_p5_ev.editorial.service.IAutorService;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@SpringBootApplication
public class Pa2U3P5EvApplication implements CommandLineRunner {

//    public static void main(String... args) {
//        SpringApplication.run(Pa2U3P5EvApplication.class, args);
//    }

    @Autowired
    private IFacturaService iFacturaService;

    @Autowired
    private IAutorService iAutorService;

    @Override
    public void run(String... args) throws Exception {

    }
}
