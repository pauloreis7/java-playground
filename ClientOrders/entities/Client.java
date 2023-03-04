package ClientOrders.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
  private static final DateTimeFormatter birthDateFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private final String name;
  private final String email;
  private final LocalDate birthDate;

  public Client(final String name, final String email, final LocalDate birthDate) {
    this.name = name;
    this.email = email;
    this.birthDate = birthDate;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  @Override
  public String toString() {
    return name + " (" + birthDateFmt.format(birthDate) + ") - " + email;
  }
}
