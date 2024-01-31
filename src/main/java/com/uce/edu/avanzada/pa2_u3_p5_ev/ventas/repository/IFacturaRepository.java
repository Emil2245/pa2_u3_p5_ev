package com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository;

import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Factura;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.dto.FacturaDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface IFacturaRepository {
    Factura select(Integer id);
    Factura selectPorNumero(String numero);
    List<Factura> selectFacturasInnerJoin();
    List<Factura> selectFacturasRightJoin();
    List<Factura> selectFacturasLeftJoin();
    List<Factura> selectFacturasFullJoin();
    List<Factura> selectFacturasWhereJoin();
    List<Factura> selectFacturasJoinFetch();
    void insert(Factura factura);
    int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual);
    void actualizar(Factura factura);
    void eliminar(Integer id);
    int eliminarPorNumero(String numero);
    List<FacturaDTO> selectFacturasDTO();


}
