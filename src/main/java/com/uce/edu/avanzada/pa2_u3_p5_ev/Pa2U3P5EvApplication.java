package com.uce.edu.avanzada.pa2_u3_p5_ev;

import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository.model.Habitacion;
import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository.model.Hotel;
import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.service.IHotelService;
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
    private IHotelService iHotelService;

    @Override
    public void run(String... args) throws Exception {

        //Actualizacion
        Hotel hotel1 = new Hotel();
        hotel1.setNombre("Hotel Plata");
        hotel1.setDireccion("En la bahia");
        hotel1.setTienePiscina(true);

        Habitacion habitacion1 = new Habitacion();
        habitacion1.setClase("Plata");
        habitacion1.setHotel(hotel1);
        habitacion1.setNumero("1000");
        habitacion1.setTieneVistaPiscina(true);
        Habitacion habitacion2 = new Habitacion();
        habitacion2.setClase("Bronze");
        habitacion2.setHotel(hotel1);
        habitacion2.setNumero("1001");
        habitacion2.setTieneVistaPiscina(false);

        List<Habitacion> habitaciones2 = new ArrayList<>();
        habitaciones2.add(habitacion1);
        habitaciones2.add(habitacion2);

        hotel1.setHabitaciones(habitaciones2);

//        this.iHotelService.guardar(hotel1);


        this.iHotelService.buscarHotelsInnerJoin()
                .forEach(f -> f.getHabitaciones()
                        .forEach(System.out::println));
        System.out.println("----------------------------------");
        this.iHotelService.buscarHotelsRightJoin()
                .forEach(System.out::println);
        System.out.println("----------------------------------");
        this.iHotelService.buscarHotelsLeftJoin()
                .forEach(System.out::println);
        System.out.println("----------------------------------");
        this.iHotelService.buscarHotelsFullJoin()
                .forEach(f -> f.getHabitaciones()
                        .forEach(System.out::println));

    }
}
