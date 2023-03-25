package br.com.pauloreis.db;

public class DbIntegrityException extends RuntimeException {
  public DbIntegrityException(final String msg) {
    super(msg);
  }
}
