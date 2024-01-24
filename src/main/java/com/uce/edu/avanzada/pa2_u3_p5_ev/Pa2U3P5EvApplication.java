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
        factura.setCedula("17098098");
        factura.setFecha(LocalDateTime.now());
        factura.setNumero("0001-0001");

        DetalleFactura detalleFactura0 = new DetalleFactura();
        detalleFactura0.setCantidad(2);
        detalleFactura0.setCodigoBarras("01298374");
        detalleFactura0.setNombreProducto("Agua");
        detalleFactura0.setFactura(factura);

        DetalleFactura detalleFactura1 = new DetalleFactura();
        detalleFactura1.setCantidad(5);
        detalleFactura1.setCodigoBarras("98037450");
        detalleFactura1.setNombreProducto("Cola");
        detalleFactura1.setFactura(factura);

        DetalleFactura detalleFactura2 = new DetalleFactura();
        detalleFactura2.setCantidad(8);
        detalleFactura2.setCodigoBarras("897459038");
        detalleFactura2.setNombreProducto("Leche");
        detalleFactura2.setFactura(factura);

        DetalleFactura detalleFactura3 = new DetalleFactura();
        detalleFactura3.setCantidad(4);
        detalleFactura3.setCodigoBarras("09283475");
        detalleFactura3.setNombreProducto("Avena");
        detalleFactura3.setFactura(factura);

        List<DetalleFactura> detalleFacturasList = new ArrayList<>();
        detalleFacturasList.add(detalleFactura0);
        detalleFacturasList.add(detalleFactura1);
        detalleFacturasList.add(detalleFactura2);
        detalleFacturasList.add(detalleFactura3);

        factura.setDetalleFacturas(detalleFacturasList);

//        this.iFacturaService.guardar(factura);
        this.iFacturaService.buscarPorNumero("0001-0001").getDetalleFacturas().forEach(System.out::println);

    }
}
