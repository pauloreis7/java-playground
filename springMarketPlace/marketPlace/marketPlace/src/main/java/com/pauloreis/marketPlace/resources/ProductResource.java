package com.pauloreis.marketPlace.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pauloreis.marketPlace.entities.Product;
import com.pauloreis.marketPlace.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

  @Autowired
  private ProductService service;

  @GetMapping
  public ResponseEntity<List<Product>> findAll() {
    final List<Product> response = service.findAll();

    return ResponseEntity.ok().body(response);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Product> findById(@PathVariable final Long id) {
    final Product response = service.findById(id);

    return ResponseEntity.ok().body(response);
  }
}
