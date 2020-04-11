package com.packtpub.quarkus.chapter04.repo;

import com.packtpub.quarkus.chapter04.model.Customer;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CustomerRepo {

    private final List<Customer> list = new ArrayList<Customer>();
    private int couter;

    private int getNextCustomerId() {
        return this.couter++;
    }

    public List<Customer> findAll() {
        return this.list;
    }

    public Customer findCustomerById(Integer id) {
        return this.list.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public void createCustomer(Customer customer) {
        customer.setId(this.getNextCustomerId());
        findAll().add(customer);
    }

    public void updateCustomer(Customer customer) {
        Customer foundCustomer = this.findCustomerById(customer.getId());
        foundCustomer.setName(customer.getName());
        foundCustomer.setSurname(customer.getSurname());
    }

    public void deleteCustomer(Integer id) {
        findAll().remove(findCustomerById(id));
    }
}
