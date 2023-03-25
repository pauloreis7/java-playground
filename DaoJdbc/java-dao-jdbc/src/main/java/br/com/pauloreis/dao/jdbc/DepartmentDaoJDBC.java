package br.com.pauloreis.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.pauloreis.dao.DepartmentDao;
import br.com.pauloreis.entities.Department;
import br.com.pauloreis.db.DbException;
import br.com.pauloreis.db.DB;

public class DepartmentDaoJDBC implements DepartmentDao {

  private final Connection connection;

  public DepartmentDaoJDBC(final Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<Department> findAll() {
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      preparedStatement = connection.prepareStatement("SELECT * FROM department ORDER BY Name");
      resultSet = preparedStatement.executeQuery();

      final List<Department> departments = new ArrayList<>();

      while (resultSet.next()) {
        final Department department = instantiateDepartment(resultSet);

        departments.add(department);
      }

      return departments;
    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.closeStatement(preparedStatement);
      DB.closeResultSet(resultSet);
    }
  }

  @Override
  public Department findById(int id) {
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      preparedStatement = connection.prepareStatement("SELECT * FROM department WHERE Id = ?");

      preparedStatement.setInt(1, id);
      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        final Department department = instantiateDepartment(resultSet);

        return department;
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
  public void create(Department department) {
    PreparedStatement preparedStatement = null;

    try {
      preparedStatement = connection.prepareStatement(
          "INSERT INTO department (Name) VALUES (?)",
          Statement.RETURN_GENERATED_KEYS);

      preparedStatement.setString(1, department.getName());

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
  public void update(Department department) {
    PreparedStatement preparedStatement = null;

    try {
      preparedStatement = connection.prepareStatement("UPDATE department SET Name = ? WHERE Id = ?");

      preparedStatement.setString(1, department.getName());
      preparedStatement.setInt(2, department.getId());

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
      preparedStatement = connection.prepareStatement("DELETE FROM department WHERE Id = ?");

      preparedStatement.setInt(1, id);

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.closeStatement(preparedStatement);
    }
  }

  private Department instantiateDepartment(ResultSet resultSet) throws SQLException {
    final int id = resultSet.getInt("Id");
    final String name = resultSet.getString("Name");

    final Department department = new Department(id, name);

    return department;
  }
}
