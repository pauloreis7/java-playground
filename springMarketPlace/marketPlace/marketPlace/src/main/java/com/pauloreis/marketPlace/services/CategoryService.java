package com.pauloreis.marketPlace.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloreis.marketPlace.entities.Category;
import com.pauloreis.marketPlace.repositories.CategoryRepository;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository repository;

  public List<Category> findAll() {
    final List<Category> categories = repository.findAll();

    return categories;
  }

  public Category findById(final Long id) {
    final Optional<Category> findCategory = repository.findById(id);

    return findCategory.get();
  }
}
