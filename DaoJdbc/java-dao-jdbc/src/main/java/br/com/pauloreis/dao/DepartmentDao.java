package br.com.pauloreis.dao;

import java.util.List;

import br.com.pauloreis.entities.Department;

public interface DepartmentDao {

  List<Department> findAll();

  Department findById(final int id);

  void create(Department department);

  void update(Department department);

  void deleteById(final int id);
}
