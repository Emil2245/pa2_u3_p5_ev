package com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.service;

import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Factura;

import java.util.List;

public interface IFacturaService {
    Factura buscarPorNumero(String numero);
    List<Factura> buscarFacturasInnerJoin();
    List<Factura> buscarFacturasRightJoin();
    List<Factura> buscarFacturasLeftJoin();
    List<Factura> buscarFacturasFullJoin();
    List<Factura> buscarFacturasWhereJoin();
    List<Factura> buscarFacturasJoinFetch();
    void guardar(Factura factura);

}
