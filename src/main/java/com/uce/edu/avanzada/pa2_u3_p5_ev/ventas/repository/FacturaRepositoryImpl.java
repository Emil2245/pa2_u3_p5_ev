package com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository;

import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Factura;
import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.dto.FacturaDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Factura select(Integer id) {
        return this.entityManager.find(Factura.class,id);
    }

    @Override
    public Factura selectPorNumero(String numero) {
        TypedQuery<Factura> typedQuery =
                this.entityManager.createQuery("select f from Factura f where f.numero = :numero", Factura.class);
        typedQuery.setParameter("numero", numero);
        Factura factura = typedQuery.getResultList().get(0);
        factura.getDetalleFacturas().size();//bajo demanda, osea siguen en LAZY
        return factura;
    }

    @Override
    public List<Factura> selectFacturasInnerJoin() {
        TypedQuery<Factura> typedQuery = this.entityManager.createQuery("SELECT f FROM Factura f INNER JOIN f.detalleFacturas", Factura.class);
        List<Factura> list = typedQuery.getResultList();
        list.forEach(e -> e.getDetalleFacturas().size());//bajo demanda, osea siguen en LAZY//ahorrandonos el EAGER
        return list;
    }

    @Override
    public List<Factura> selectFacturasRightJoin() {
        TypedQuery<Factura> typedQuery = this.entityManager.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detalleFacturas d", Factura.class);
        List<Factura> list = typedQuery.getResultList();
        list.forEach(e -> e.getDetalleFacturas().size());//bajo demanda, osea siguen en LAZY
        return list;
    }

    @Override
    public List<Factura> selectFacturasLeftJoin() {
        TypedQuery<Factura> typedQuery = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalleFacturas d", Factura.class);
        List<Factura> list = typedQuery.getResultList();
        list.forEach(e -> e.getDetalleFacturas().size());//bajo demanda, osea siguen en LAZY
        return list;
    }

    @Override
    public List<Factura> selectFacturasFullJoin() {
        TypedQuery<Factura> typedQuery = this.entityManager.createQuery("SELECT f FROM Factura f FULL JOIN f.detalleFacturas d", Factura.class);
        List<Factura> list = typedQuery.getResultList();
        list.forEach(e -> e.getDetalleFacturas().size());//bajo demanda, osea siguen en LAZY
        return list;
    }

    @Override
    public List<Factura> selectFacturasWhereJoin() {
        TypedQuery<Factura> query =
                this.entityManager.createQuery("select f from Factura f, DetalleFactura m where f = m.factura", Factura.class);
        List<Factura> lista = query.getResultList();
        lista.forEach(factura -> factura.getDetalleFacturas().size());//bajo demanda, osea siguen en LAZY
        return lista;
    }

    @Override
    public List<Factura> selectFacturasJoinFetch() //no hace falta la demanda de detalles al JPA
    {
        TypedQuery<Factura> query =
                this.entityManager.createQuery("select f from Factura f join fetch f.detalleFacturas", Factura.class);
        return query.getResultList();
    }

    @Override
    public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
        Query query = this.entityManager.createQuery("update Factura f set f.fecha = :fechaActual where f.fecha >= :fechaNueva");
        query.setParameter("fechaNueva", fechaNueva);
        query.setParameter("fechaActual", fechaActual);
        return query.executeUpdate();
    }

    @Override
    public void actualizar(Factura factura) {
        this.entityManager.merge(factura);
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.select(id));

    }

    @Override
    public int eliminarPorNumero(String numero) {
        Query query = this.entityManager.createQuery("delete Factura f where f.numero= :numero");
        query.setParameter("numero", numero);
        return query.executeUpdate();
    }

    @Override
    public void insert(Factura factura) {
        this.entityManager.persist(factura);
    }

    @Override
    public List<FacturaDTO> selectFacturasDTO() {
//        TypedQuery<FacturaDTO> query = this.entityManager.createQuery("select new com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.dto.FacturaDTO(f.numero,f.fecha) from Factura f", FacturaDTO.class);
//        return query.getResultList();
        return this.entityManager.createQuery("select f.numero,f.fecha from Factura f", FacturaDTO.class).getResultList();
    }


}
