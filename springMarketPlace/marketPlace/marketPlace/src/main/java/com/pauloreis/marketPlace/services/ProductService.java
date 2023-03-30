package com.pauloreis.marketPlace.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloreis.marketPlace.entities.Product;
import com.pauloreis.marketPlace.repositories.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;

  public List<Product> findAll() {
    final List<Product> products = repository.findAll();

    return products;
  }

  public Product findById(final Long id) {
    final Optional<Product> findProduct = repository.findById(id);

    return findProduct.get();
  }
}
