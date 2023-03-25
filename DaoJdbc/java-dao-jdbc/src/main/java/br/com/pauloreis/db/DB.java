package br.com.pauloreis.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

  private static Connection connection = null;

  public static Connection getConnection() {

    String connectionUrl = "jdbc:postgresql://localhost:5432/javadb?currentSchema=public";

    if (connection == null) {
      try {
        connection = DriverManager.getConnection(connectionUrl, "postgres", "12345");

      } catch (SQLException e) {
        throw new DbException(e.getMessage());
      }
    }

    return connection;
  }

  public static void closeConnection() {
    if (connection != null) {
      try {

        connection.close();
      } catch (SQLException e) {
        throw new DbException(e.getMessage());
      }
    }
  }

  public static void closeStatement(final Statement statement) {
    if (statement != null) {
      try {
        statement.close();
      } catch (SQLException e) {
        throw new DbException(e.getMessage());
      }
    }
  }

  public static void closeResultSet(final ResultSet resultSet) {
    if (resultSet != null) {
      try {
        resultSet.close();
      } catch (SQLException e) {
        throw new DbException(e.getMessage());
      }
    }
  }
}
