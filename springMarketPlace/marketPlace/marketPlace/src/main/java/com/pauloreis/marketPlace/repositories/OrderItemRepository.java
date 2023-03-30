package com.pauloreis.marketPlace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pauloreis.marketPlace.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
