package com.pauloreis.marketPlace.resources;

import java.net.URI;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pauloreis.marketPlace.entities.Customer;
import com.pauloreis.marketPlace.services.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

  @Autowired
  private CustomerService service;

  @GetMapping
  public ResponseEntity<List<Customer>> findAll() {
    final List<Customer> response = service.findAll();

    return ResponseEntity.ok().body(response);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Customer> findById(@PathVariable final Long id) {
    final Customer response = service.findById(id);

    return ResponseEntity.ok().body(response);
  }

  @PostMapping
  public ResponseEntity<Customer> insert(@RequestBody final Customer customer) {
    final Customer response = service.insert(customer);

    final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(response.getId()).toUri();

    return ResponseEntity.created(uri).body(response);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Customer> update(@PathVariable final Long id, @RequestBody final Customer data) {
    final Customer response = service.update(id, data);

    return ResponseEntity.ok().body(response);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable final Long id) {
    service.delete(id);

    return ResponseEntity.noContent().build();
  }
}
