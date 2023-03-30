package com.pauloreis.marketPlace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pauloreis.marketPlace.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
