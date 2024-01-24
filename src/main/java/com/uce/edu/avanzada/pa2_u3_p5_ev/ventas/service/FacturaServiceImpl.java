package com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.service;

import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.IFacturaRepository;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl implements IFacturaService {
    @Autowired
    private IFacturaRepository iFacturaRepository;

    @Override
    public Factura buscarPorNumero(String numero) {
        return this.iFacturaRepository.selectPorNumero(numero);
    }

    @Override
    public void guardar(Factura factura) {
        this.iFacturaRepository.insert(factura);
    }
}
