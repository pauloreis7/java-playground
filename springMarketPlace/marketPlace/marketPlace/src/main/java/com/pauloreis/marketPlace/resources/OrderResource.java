package com.pauloreis.marketPlace.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pauloreis.marketPlace.entities.Order;
import com.pauloreis.marketPlace.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

  @Autowired
  private OrderService service;

  @GetMapping
  public ResponseEntity<List<Order>> findAll() {
    final List<Order> response = service.findAll();

    return ResponseEntity.ok().body(response);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Order> findById(@PathVariable final Long id) {
    final Order response = service.findById(id);

    return ResponseEntity.ok().body(response);
  }
}
