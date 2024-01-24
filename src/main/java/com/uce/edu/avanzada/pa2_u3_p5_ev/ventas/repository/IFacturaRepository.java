package com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository;

import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Factura;
import org.springframework.data.repository.core.CrudMethods;

public interface IFacturaRepository {
    Factura selectPorNumero(String numero);
    void insert(Factura factura);

}
