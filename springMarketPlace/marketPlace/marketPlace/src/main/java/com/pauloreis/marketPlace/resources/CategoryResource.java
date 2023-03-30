package com.pauloreis.marketPlace.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pauloreis.marketPlace.entities.Category;
import com.pauloreis.marketPlace.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

  @Autowired
  private CategoryService service;

  @GetMapping
  public ResponseEntity<List<Category>> findAll() {
    final List<Category> response = service.findAll();

    return ResponseEntity.ok().body(response);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Category> findById(@PathVariable final Long id) {
    final Category response = service.findById(id);

    return ResponseEntity.ok().body(response);
  }
}
