package br.com.pauloreis.dao;

import java.util.List;

import br.com.pauloreis.entities.Seller;

public interface SellerDao {

  List<Seller> findAll();

  Seller findById(final int id);

  List<Seller> findByDepartment(final int departmentId);

  void create(Seller seller);

  void update(Seller seller);

  void deleteById(final int id);
}
