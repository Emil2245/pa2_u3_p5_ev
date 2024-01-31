package com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.service;

import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.IFacturaRepository;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Factura;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.dto.FacturaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FacturaServiceImpl implements IFacturaService {
    @Autowired
    private IFacturaRepository iFacturaRepository;

    @Override
    public Factura buscarPorNumero(String numero) {
        return this.iFacturaRepository.selectPorNumero(numero);
    }

    @Override
    public List<Factura> buscarFacturasInnerJoin() {
        return this.iFacturaRepository.selectFacturasInnerJoin();
    }

    @Override
    public List<Factura> buscarFacturasRightJoin() {
        return this.iFacturaRepository.selectFacturasRightJoin();
    }

    @Override
    public List<Factura> buscarFacturasLeftJoin() {
        return this.iFacturaRepository.selectFacturasLeftJoin();
    }

    @Override
    public List<Factura> buscarFacturasFullJoin() {
        return this.iFacturaRepository.selectFacturasFullJoin();
    }

    @Override
    public List<Factura> buscarFacturasWhereJoin() {
        return this.iFacturaRepository.selectFacturasWhereJoin();
    }

    @Override
    public List<Factura> buscarFacturasJoinFetch() {
        return this.iFacturaRepository.selectFacturasJoinFetch();
    }

    @Override
    public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
        return this.iFacturaRepository.actualizarFechas(fechaNueva,fechaActual);
    }

    @Override
    public void guardar(Factura factura) {
        this.iFacturaRepository.insert(factura);
    }

    @Override
    public void actualizar(Factura factura) {
        this.iFacturaRepository.actualizar(factura);
    }

    @Override
    public int borrarPorNumero(String numero) {
        return this.iFacturaRepository.eliminarPorNumero(numero);

    }

    @Override
    public void borrar(Integer id) {
        this.iFacturaRepository.eliminar(id);
    }

    @Override
    public List<FacturaDTO> buscarFacturasDTO() {
        return this.iFacturaRepository.selectFacturasDTO();
    }
}
