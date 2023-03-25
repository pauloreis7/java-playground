package br.com.pauloreis.db;

public class DbException extends RuntimeException {
  public DbException(final String msg) {
    super(msg);
  }
}
