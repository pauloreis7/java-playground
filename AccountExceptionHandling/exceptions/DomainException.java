package AccountExceptionHandling.exceptions;

public class DomainException extends RuntimeException {

  public DomainException(final String errorMessage) {
    super(errorMessage);
  }
}
