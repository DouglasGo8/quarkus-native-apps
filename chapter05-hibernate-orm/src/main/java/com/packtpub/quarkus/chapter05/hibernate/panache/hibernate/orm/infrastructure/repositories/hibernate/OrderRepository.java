package com.packtpub.quarkus.chapter05.hibernate.panache.hibernate.orm.infrastructure.repositories.hibernate;

import com.packtpub.quarkus.chapter05.hibernate.panache.hibernate.orm.domain.model.entities.Order;

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
