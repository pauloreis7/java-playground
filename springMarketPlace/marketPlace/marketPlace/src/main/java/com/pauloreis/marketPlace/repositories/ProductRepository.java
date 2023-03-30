package com.pauloreis.marketPlace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pauloreis.marketPlace.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
