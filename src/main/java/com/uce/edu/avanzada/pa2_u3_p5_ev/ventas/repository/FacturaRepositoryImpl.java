package com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository;

import com.uce.edu.avanzada.pa2_u3_p5_ev.ventas.repository.model.Factura;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository
{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Factura selectPorNumero(String numero) {
        TypedQuery<Factura> typedQuery =
                this.entityManager.createQuery("select f from Factura f where f.numero = :numero", Factura.class);
        typedQuery.setParameter("numero",numero);
        Factura factura = typedQuery.getResultList().get(0);
        factura.getDetalleFacturas().size();//bajo demanda, osea siguen en LAZY
        return factura;
    }

    @Override
    public void insert(Factura factura) {
        this.entityManager.persist(factura);
    }
}
