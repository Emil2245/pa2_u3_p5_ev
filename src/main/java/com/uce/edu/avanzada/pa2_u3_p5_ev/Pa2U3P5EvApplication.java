package com.uce.edu.avanzada.pa2_u3_p5_ev;

import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.DetalleFactura;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Factura;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
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
        Factura factura = new Factura();
        factura.setCedula("948735984");
        factura.setFecha(LocalDateTime.now());
        factura.setNumero("0004-0004");

        DetalleFactura detalleFactura0 = new DetalleFactura();
        detalleFactura0.setCantidad(2);
        detalleFactura0.setCodigoBarras("8459879384");
        detalleFactura0.setNombreProducto("Quesadilla");
        detalleFactura0.setFactura(factura);

        DetalleFactura detalleFactura1 = new DetalleFactura();
        detalleFactura1.setCantidad(5);
        detalleFactura1.setCodigoBarras("39485793847");
        detalleFactura1.setNombreProducto("Frejo");
        detalleFactura1.setFactura(factura);

        DetalleFactura detalleFactura2 = new DetalleFactura();
        detalleFactura2.setCantidad(17);
        detalleFactura2.setCodigoBarras("3495837495");
        detalleFactura2.setNombreProducto("Chocolate");
        detalleFactura2.setFactura(factura);

        DetalleFactura detalleFactura3 = new DetalleFactura();
        detalleFactura3.setCantidad(8);
        detalleFactura3.setCodigoBarras("8594859");
        detalleFactura3.setNombreProducto("Helado");
        detalleFactura3.setFactura(factura);

        List<DetalleFactura> detalleFacturasList = new ArrayList<>();
        detalleFacturasList.add(detalleFactura0);
        detalleFacturasList.add(detalleFactura1);
        detalleFacturasList.add(detalleFactura2);
        detalleFacturasList.add(detalleFactura3);

        factura.setDetalleFacturas(detalleFacturasList);

//        this.iFacturaService.guardar(factura);

        System.out.println("----------------------------------");
        this.iFacturaService.buscarFacturasInnerJoin()
                .forEach(f -> f.getDetalleFacturas()
                        .forEach(System.out::println));
        System.out.println("----------------------------------");
        this.iFacturaService.buscarFacturasRightJoin()
                        .forEach(System.out::println);
        System.out.println("----------------------------------");
        this.iFacturaService.buscarFacturasLeftJoin()
                        .forEach(System.out::println);
        System.out.println("----------------------------------");
        this.iFacturaService.buscarFacturasFullJoin()
                        .forEach(f -> f.getDetalleFacturas()
                                .forEach(System.out::println));


    }
}
