package br.com.pauloreis.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.pauloreis.dao.SellerDao;
import br.com.pauloreis.entities.Department;
import br.com.pauloreis.entities.Seller;
import br.com.pauloreis.db.DbException;
import br.com.pauloreis.db.DB;

public class SellerDaoJDBC implements SellerDao {

  private final Connection connection;

  public SellerDaoJDBC(final Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<Seller> findAll() {
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      preparedStatement = connection.prepareStatement(
          "SELECT seller.*,department.Name as DepName FROM seller "
              + "INNER JOIN department ON seller.DepartmentId = department.Id "
              + "ORDER BY Name");

      resultSet = preparedStatement.executeQuery();

      final List<Seller> sellers = new ArrayList<>();
      final Map<Integer, Department> departments = new HashMap<>();

      while (resultSet.next()) {
        final int departmentId = resultSet.getInt("DepartmentId");
        Department department = departments.get(departmentId);

        if (department == null) {
          department = instantiateDepartment(resultSet);
          departments.put(departmentId, department);
        }

        final Seller seller = instantiateSeller(resultSet, department);
        sellers.add(seller);
      }

      return sellers;
    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.closeStatement(preparedStatement);
      DB.closeResultSet(resultSet);
    }
  }

  @Override
  public Seller findById(int id) {
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      preparedStatement = connection.prepareStatement(
          "SELECT seller.*,department.Name as DepName FROM seller "
              + "INNER JOIN department ON seller.DepartmentId = department.Id "
              + "WHERE seller.Id = ?");

      preparedStatement.setInt(1, id);
      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        final Department department = instantiateDepartment(resultSet);
        final Seller seller = instantiateSeller(resultSet, department);
        return seller;
      }

      return null;
    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.closeStatement(preparedStatement);
      DB.closeResultSet(resultSet);
    }
  }

  @Override
  public List<Seller> findByDepartment(int departmentId) {
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      preparedStatement = connection.prepareStatement(
          "SELECT seller.*,department.Name as DepName FROM seller "
              + "INNER JOIN department ON seller.DepartmentId = department.Id "
              + "WHERE DepartmentId = ? ORDER BY Name");

      preparedStatement.setInt(1, departmentId);
      resultSet = preparedStatement.executeQuery();

      final List<Seller> sellers = new ArrayList<>();
      final Map<Integer, Department> departments = new HashMap<>();

      while (resultSet.next()) {
        Department department = departments.get(departmentId);

        if (department == null) {
          department = instantiateDepartment(resultSet);
          departments.put(departmentId, department);
        }

        final Seller seller = instantiateSeller(resultSet, department);
        sellers.add(seller);
      }

      return sellers;
    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.closeStatement(preparedStatement);
      DB.closeResultSet(resultSet);
    }
  }

  @Override
  public void create(Seller seller) {
    PreparedStatement preparedStatement = null;

    try {
      preparedStatement = connection.prepareStatement(
          "INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES (?, ?, ?, ?, ?)",
          Statement.RETURN_GENERATED_KEYS);

      preparedStatement.setString(1, seller.getName());
      preparedStatement.setString(2, seller.getEmail());
      preparedStatement.setDate(3, java.sql.Date.valueOf(seller.getBirthDate()));
      preparedStatement.setDouble(4, seller.getBaseSalary());
      preparedStatement.setInt(5, seller.getDepartment().getId());

      final int rowsAffected = preparedStatement.executeUpdate();

      if (rowsAffected == 0) {
        throw new DbException("Unexpected error! No rows affected!");
      }
    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.closeStatement(preparedStatement);
    }
  }

  @Override
  public void update(Seller seller) {
    PreparedStatement preparedStatement = null;

    try {
      preparedStatement = connection.prepareStatement(
          "UPDATE seller SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? "
              + "WHERE Id = ?");

      preparedStatement.setString(1, seller.getName());
      preparedStatement.setString(2, seller.getEmail());
      preparedStatement.setDate(3, java.sql.Date.valueOf(seller.getBirthDate()));
      preparedStatement.setDouble(4, seller.getBaseSalary());
      preparedStatement.setInt(5, seller.getDepartment().getId());
      preparedStatement.setInt(6, seller.getId());

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.closeStatement(preparedStatement);
    }
  }

  @Override
  public void deleteById(int id) {
    PreparedStatement preparedStatement = null;

    try {
      preparedStatement = connection.prepareStatement("DELETE FROM seller WHERE Id = ?");

      preparedStatement.setInt(1, id);

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.closeStatement(preparedStatement);
    }
  }

  private Seller instantiateSeller(ResultSet resultSet, Department department) throws SQLException {
    final int id = resultSet.getInt("Id");
    final String name = resultSet.getString("Name");
    final String email = resultSet.getString("Email");
    final Date birthDate = resultSet.getDate("BirthDate");
    final double baseSalary = resultSet.getDouble("BaseSalary");

    final Seller seller = new Seller(id, name, email, birthDate.toLocalDate(), baseSalary, department);

    return seller;
  }

  private Department instantiateDepartment(ResultSet resultSet) throws SQLException {
    final int id = resultSet.getInt("DepartmentId");
    final String name = resultSet.getString("DepName");

    final Department department = new Department(id, name);

    return department;
  }
}
