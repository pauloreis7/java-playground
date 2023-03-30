package com.pauloreis.marketPlace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pauloreis.marketPlace.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
