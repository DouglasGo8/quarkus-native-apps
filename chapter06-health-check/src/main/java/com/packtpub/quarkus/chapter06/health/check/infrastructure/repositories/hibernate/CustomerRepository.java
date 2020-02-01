package com.packtpub.quarkus.chapter06.health.check.infrastructure.repositories.hibernate;


import com.packtpub.quarkus.chapter06.health.check.domain.model.entities.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CustomerRepository {

    @Inject
    private EntityManager entity;

    public Customer findCustomerById(Long id) {
        return Optional.ofNullable(entity.find(Customer.class, id)).orElseThrow(RuntimeException::new);
    }

    public List<Customer> findAll() {
        return entity.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }

}
