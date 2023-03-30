package com.pauloreis.marketPlace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pauloreis.marketPlace.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
