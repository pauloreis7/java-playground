package com.pauloreis.marketPlace.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.pauloreis.marketPlace.entities.Customer;
import com.pauloreis.marketPlace.repositories.CustomerRepository;
import com.pauloreis.marketPlace.services.exceptions.DatabaseException;
import com.pauloreis.marketPlace.services.exceptions.ResourceNotFoundException;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository repository;

  public List<Customer> findAll() {
    final List<Customer> customers = repository.findAll();

    return customers;
  }

  public Customer findById(final Long id) {
    final Optional<Customer> findCustomer = repository.findById(id);

    return findCustomer.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public Customer insert(final Customer customer) {
    final Customer result = repository.save(customer);

    return result;
  }

  public void delete(final Long id) {
    try {
      repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

      repository.deleteById(id);
    } catch (ResourceNotFoundException e) {
      throw new ResourceNotFoundException(id);
    } catch (DataIntegrityViolationException e) {
      throw new DatabaseException(e.getMessage());
    }
  }

  public Customer update(final Long id, final Customer data) {
    try {
      final Customer findCustomer = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

      final Customer updattedCustomer = new Customer(
          findCustomer.getId(),
          data.getName(),
          data.getEmail(),
          data.getPhone(),
          findCustomer.getPassword());

      return repository.save(updattedCustomer);
    } catch (ResourceNotFoundException e) {
      throw new ResourceNotFoundException(id);
    }
  }
}
