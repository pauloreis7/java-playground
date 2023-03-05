package ProductsTags.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {
  private static final DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private final LocalDate manufactureDate;

  public UsedProduct(final String name, final double price, final LocalDate manufactureDate) {
    super(name, price);

    this.manufactureDate = manufactureDate;
  }

  public LocalDate getManufactureDate() {
    return manufactureDate;
  }

  @Override
  public String priceTag() {
    return String.format("%s (used) $ %.2f (Manufacture date: %s)", getName(), getPrice(),
        getManufactureDate().format(dateFmt));
  }
}
