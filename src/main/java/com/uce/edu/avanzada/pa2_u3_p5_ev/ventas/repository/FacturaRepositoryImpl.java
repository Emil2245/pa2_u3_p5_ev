package com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository;

import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Factura;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {
    @PersistenceContext
    private EntityManager entityManager;

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
        TypedQuery<Factura> typedQuery = this.entityManager.createQuery("SELECT f FROM Factura f INNER JOIN f.detalleFacturas d", Factura.class);
        List<Factura> list = typedQuery.getResultList();
        list.forEach(e -> e.getDetalleFacturas().size());//ahorrandonos el EAGER
        return list;
    }

    @Override
    public List<Factura> selectFacturasRightJoin() {
        TypedQuery<Factura> typedQuery = this.entityManager.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detalleFacturas d", Factura.class);
        List<Factura> list = typedQuery.getResultList();
        list.forEach(e -> e.getDetalleFacturas().size());
        return list;
    }

    @Override
    public List<Factura> selectFacturasLeftJoin() {
        TypedQuery<Factura> typedQuery = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalleFacturas d", Factura.class);
        List<Factura> list = typedQuery.getResultList();
        list.forEach(e -> e.getDetalleFacturas().size());
        return list;
    }

    @Override
    public List<Factura> selectFacturasFullJoin() {
        TypedQuery<Factura> typedQuery = this.entityManager.createQuery("SELECT f FROM Factura f FULL JOIN f.detalleFacturas d", Factura.class);
        List<Factura> list = typedQuery.getResultList();
        list.forEach(e -> e.getDetalleFacturas().size());
        return list;
    }

    @Override
    public void insert(Factura factura) {
        this.entityManager.persist(factura);
    }
}
