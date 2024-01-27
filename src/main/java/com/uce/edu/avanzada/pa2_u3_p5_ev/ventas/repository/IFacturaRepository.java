package com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository;

import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Factura;

import java.util.List;

public interface IFacturaRepository {
    Factura selectPorNumero(String numero);
    List<Factura> selectFacturasInnerJoin();
    List<Factura> selectFacturasRightJoin();
    List<Factura> selectFacturasLeftJoin();
    List<Factura> selectFacturasFullJoin();
    void insert(Factura factura);

}
