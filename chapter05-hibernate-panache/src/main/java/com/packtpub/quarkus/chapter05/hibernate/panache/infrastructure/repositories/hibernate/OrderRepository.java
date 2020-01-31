package com.packtpub.quarkus.chapter05.hibernate.panache.infrastructure.repositories.hibernate;

import com.packtpub.quarkus.chapter05.hibernate.panache.domain.model.entities.Customer;
import com.packtpub.quarkus.chapter05.hibernate.panache.domain.model.entities.Order;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import java.util.List;

@ApplicationScoped
public class OrderRepository {


    @Inject
    private EntityManager entityManager;


    public List<Order> findAll(Long customerId) {

        List<Order> l = Order.list("customer.id", Sort.by("item"), customerId);
        return l;
    }

    public Order findOrderById(Long id) {

        Order order = Order.findById(id);

        if (order == null) {
            throw new WebApplicationException("Order with id of " + id + " does not exist.", 404);
        }
        return order;
    }

    @Transactional
    public void updateOrder(Order order) {

        Order orderToUpdate = findOrderById(order.getId());
        orderToUpdate.setItem(order.getItem());
        orderToUpdate.setPrice(order.getPrice());
    }

    @Transactional
    public void createOrder(Order order, Customer c) {

        order.customer = c;
        order.persist();

    }

    @Transactional
    public void deleteOrder(Long orderId) {

        Order order = findOrderById(orderId);
        order.delete();

    }
}