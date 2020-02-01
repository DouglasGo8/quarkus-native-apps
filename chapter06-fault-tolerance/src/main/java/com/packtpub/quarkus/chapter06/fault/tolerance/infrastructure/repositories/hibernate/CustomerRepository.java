package com.packtpub.quarkus.chapter06.fault.tolerance.infrastructure.repositories.hibernate;

import com.packtpub.quarkus.chapter06.fault.tolerance.domain.model.entities.Customer;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CustomerRepository {

    @Inject
    private EntityManager entityManager;

    @Timeout(250)
    @Retry(maxRetries = 3)
    //@Fallback(fallbackMethod = "findAllWithStaticData")
    public List<Customer> findAll() {
        return this.entityManager.createNamedQuery("Customers.findAll", Customer.class)
                .getResultList();
    }

}