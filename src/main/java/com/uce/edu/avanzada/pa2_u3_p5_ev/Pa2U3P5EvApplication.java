package com.uce.edu.avanzada.pa2_u3_p5_ev;

import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository.model.Habitacion;
import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.repository.model.Hotel;
import com.uce.edu.avanzada.pa2_u3_p5_ev.hotel.service.IHotelService;
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

    @Override
    public void run(String... args) throws Exception {

        this.iFacturaService.buscarFacturasWhereJoin().forEach(factura ->
                factura.getDetalleFacturas().forEach(detalleFactura ->
                        System.out.println(detalleFactura.getNombreProducto())));
        System.out.println("------------------------------------------");
        this.iFacturaService.buscarFacturasInnerJoin().forEach(factura ->
        {
            System.out.println(factura.getNumero());
            factura.getDetalleFacturas().forEach(detalleFactura ->
                    System.out.println(detalleFactura.getNombreProducto()));
        });
        System.out.println("------------------------------------------");
        this.iFacturaService.buscarFacturasJoinFetch().forEach(factura ->
        {
            System.out.println(factura.getNumero());
            factura.getDetalleFacturas().forEach(detalleFactura ->
                    System.out.println(detalleFactura.getNombreProducto()));
        });


    }
}
