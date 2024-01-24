package com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.service;

import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Factura;

public interface IFacturaService {
    Factura buscarPorNumero(String numero);
    void guardar(Factura factura);

}
