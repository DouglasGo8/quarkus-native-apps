package com.packtpub.apps.quarkus.infrastructure.jdbc;

import com.packtpub.apps.quarkus.model.entities.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class OrderRepository {

    @Inject
    private EntityManager entity;

    public List<Order> findAll(Long customerId) {
        return entity.createNamedQuery("Orders.findAll", Order.class)
                .setParameter("customerId", customerId)
                .getResultList();
    }


}
