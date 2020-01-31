package com.packtpub.quarkus.chapter05.hibernate.panache.infrastructure.repositories.hibernate;

import com.packtpub.quarkus.chapter05.hibernate.panache.domain.model.entities.Customer;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import java.util.List;

@ApplicationScoped
public class CustomerRepository {


    public List<Customer> findAll() {

        return Customer.listAll(Sort.by("id"));

    }

    public Customer findCustomerById(Long id) {
        Customer customer = Customer.findById(id);


        if (customer == null) {
            throw new WebApplicationException("Customer with id of " + id + " does not exist.", 404);
        }
        return customer;
    }

    @Transactional
    public void updateCustomer(Customer customer) {

        Customer customerToUpdate = findCustomerById(customer.getId());
        customerToUpdate.setName( customer.getName());
        customerToUpdate.setSurname(customer.getSurname());
    }

    @Transactional
    public void createCustomer(Customer customer) {

        customer.persist();

    }

    @Transactional
    public void deleteCustomer(Long customerId) {

        Customer customer = findCustomerById(customerId);
        customer.delete();


    }
}