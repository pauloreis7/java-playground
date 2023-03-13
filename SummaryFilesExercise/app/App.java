package SummaryFilesExercise.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import SummaryFilesExercise.entities.Product;

public class App {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    List<Product> products = new ArrayList<Product>();

    final String csvPath = "SummaryFilesExercise/data/products.csv";

    final File sourceFile = new File(csvPath);
    final String sourceFolderStr = sourceFile.getParent();
    final String targetFileStr = sourceFolderStr + "/out/summary.csv";

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvPath))) {
      String line = bufferedReader.readLine();

      while (line != null) {
        final String[] fields = line.split(",");
        final String name = fields[0];
        final Double price = Double.parseDouble(fields[1]);
        final Integer quantity = Integer.parseInt(fields[2]);

        final Product product = new Product(name, price, quantity);

        products.add(product);

        line = bufferedReader.readLine();
      }

      final boolean success = new File(sourceFolderStr + "/out").mkdir();

      if (!success) {
        throw new IOException("Error on create out folder");
      }
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }

    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetFileStr))) {

      for (Product product : products) {
        final String newLine = String.format("%s, %.2f", product.getName(), product.total());

        bufferedWriter.write(newLine);
        bufferedWriter.newLine();
      }

      System.out.println(targetFileStr + " CREATED!");

    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
