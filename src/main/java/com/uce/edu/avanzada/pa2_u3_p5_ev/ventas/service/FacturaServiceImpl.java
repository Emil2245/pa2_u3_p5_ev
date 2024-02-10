package com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.service;

import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.IFacturaRepository;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Cliente;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Factura;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.dto.FacturaDTO;
import jakarta.transaction.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FacturaServiceImpl implements IFacturaService {
    @Autowired
    private IFacturaRepository iFacturaRepository;
    @Autowired
    private IClienteService iClienteService;

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
    @Transactional(value = Transactional.TxType.REQUIRED)
    public void guardar(Factura factura, Cliente cliente) {
//        BigDecimal valor = new BigDecimal(100);
//        valor= valor.multiply(factura.getIVA());

        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        this.iFacturaRepository.insert(factura);

        try{
            this.iClienteService.guardar(cliente);
        }catch (Exception ignored){
        }
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

    @Override
    @Transactional(value = Transactional.TxType.NOT_SUPPORTED)
    public void prueba() {
        System.out.println("Este metodo es de prueba");
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public void pruebaSupports() {
        System.out.println("Un metodo supports");
        System.out.println("Prueba supports Factura: "+TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("------------------------------------");
        this.iClienteService.pruebaSupports();
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public List<Factura> buscarTodo() {
        return this.iFacturaRepository.selectTodo();
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public void pruebaNever() {
        System.out.println("Un metodo never");
        System.out.println("Prueba never Factura: "+TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("------------------------------------");
        this.iClienteService.pruebaNever();
    }
}
