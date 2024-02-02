package com.uce.edu.avanzada.pa2_u3_p5_ev;

import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository.model.Hotel;
import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.service.IHotelService;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Factura;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.*;


@SpringBootApplication
public class Pa2U3P5EvApplication implements CommandLineRunner {

    public static void main(String... args) {
        SpringApplication.run(Pa2U3P5EvApplication.class, args);
    }

    @Autowired
    private IHotelService iHotelService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("---------------------------------------");
        //InnerJoin
        this.iHotelService.buscarHotelsWithHabitaciones().forEach(hotel -> hotel.getHabitaciones().forEach(System.out::println));
        this.iHotelService.buscarHotelByNameWithHabitaciones("Hotel Plata").forEach(hotel -> hotel.getHabitaciones().forEach(System.out::println));
        System.out.println("---------------------------------------");
        //LeftJoin
        this.iHotelService.buscarAllHotels().forEach(hotel -> hotel.getHabitaciones().forEach(System.out::println));
        this.iHotelService.buscarAllHotelsWithPool().forEach(hotel -> hotel.getHabitaciones().forEach(System.out::println));
        System.out.println("---------------------------------------");
        //RightJoin
        this.iHotelService.buscarAllHabitaciones().forEach(System.out::println);
        this.iHotelService.buscarAllHabitacionesByDireccion("En la orillita").forEach(System.out::println);
        System.out.println("---------------------------------------");
        //fullJoin
        this.iHotelService.buscarHabitacionesConVistaPiscina().forEach(hotel -> hotel.getHabitaciones().forEach(System.out::println));
        this.iHotelService.buscarHabitacionesSinVistaPiscina().forEach(hotel -> hotel.getHabitaciones().forEach(System.out::println));
        System.out.println("---------------------------------------");
        //fetch
        this.iHotelService.buscarHotelConPiscina().forEach(hotel -> hotel.getHabitaciones().forEach(System.out::println));
        this.iHotelService.buscarHotelSinPiscina().forEach(hotel -> hotel.getHabitaciones().forEach(System.out::println));
        System.out.println("---------------------------------------");

    }
}
