package com.pauloreis.marketPlace.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloreis.marketPlace.entities.Order;
import com.pauloreis.marketPlace.repositories.OrderRepository;

@Service
public class OrderService {

  @Autowired
  private OrderRepository repository;

  public List<Order> findAll() {
    final List<Order> orders = repository.findAll();

    return orders;
  }

  public Order findById(final Long id) {
    final Optional<Order> findOrder = repository.findById(id);

    return findOrder.get();
  }
}
