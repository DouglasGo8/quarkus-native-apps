package com.packtpub.apps.quarkus.infrastructure.jdbc;


import com.packtpub.apps.quarkus.model.entities.Customer;

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

    @Transactional
    public void updateCustomer(Customer customer) {
        Customer ofCustomer = this.findCustomerById(customer.getId());

        ofCustomer.setName(customer.getName());
        ofCustomer.setSurname(customer.getSurname());
    }

    @Transactional
    public void createCustomer(Customer customer) {
        this.entity.persist(customer);
    }

    @Transactional
    public void deleteCustomer(Customer customer) {
        Customer ofCustomer = this.findCustomerById(customer.getId());
        this.entity.remove(ofCustomer);
    }

}
