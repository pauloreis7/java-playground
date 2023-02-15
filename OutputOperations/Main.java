import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Main {

  public static void main(String[] args) {
    ArrayList<Product> products = new ArrayList<Product>();

    Product product01 = new Product("Computer", 2100);
    Product product02 = new Product("Mouse", 650.50);

    products.addAll(Arrays.asList(product01, product02));

    System.out.println("Products:");

    for (Product product : products) {
      System.out.println(product);
    }

    final int age = 30;
    final int code = 5390;
    final char gender = 'F';

    System.out.printf("Record: %d years old, code %d and gender: %c \n", age, code, gender);

    double measure = 53.234567;

    System.out.format("Measure with eigth decimal places: %.8f \n", measure);
    System.out.format("Rounded (three decimal places): %.3f \n", measure);

    Locale.setDefault(Locale.US);

    System.out.println("US decimal point: " + measure);
  }
}
