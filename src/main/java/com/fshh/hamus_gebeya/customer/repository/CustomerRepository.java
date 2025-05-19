package com.fshh.hamus_gebeya.customer.repository;

import com.fshh.hamus_gebeya.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
