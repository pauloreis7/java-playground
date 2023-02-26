package VectorsExercises.GenderMetrics;

import java.util.Locale;
import java.util.Scanner;

class Person {
  private final char gender;
  private final double height;

  public Person(final char gender, final double height) {
    this.gender = gender;
    this.height = height;
  }

  public char getGender() {
    return gender;
  }

  public double getHeight() {
    return height;
  }
}

public class GenderMetrics {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the amount of people to be entered:");
    int amount = scanner.nextInt();

    double lowerHeight = 10, greaterHeight = 0, womenHeightSum = 0;
    int womenCount = 0, manCount = 0;

    Person[] personVector = new Person[amount];

    for (int i = 0; i < personVector.length; i++) {
      System.out.println();

      int personNumber = i + 1;

      System.out.printf("Person %dº data:\n", personNumber);

      System.out.printf("Person %dº height:", personNumber);
      double height = scanner.nextDouble();

      scanner.nextLine();

      System.out.printf("Person %dº gender:", personNumber);
      char gender = scanner.nextLine().charAt(0);

      personVector[i] = new Person(gender, height);

      if (height < lowerHeight) {
        lowerHeight = height;
      }

      if (height > greaterHeight) {
        greaterHeight = height;
      }

      if (gender == 'M') {
        manCount++;
        continue;
      }

      if (gender == 'F') {
        womenCount++;
        womenHeightSum += height;
      }
    }

    System.out.println();

    System.out.printf("LOWER HEIGHT: %.2f \n", lowerHeight);
    System.out.printf("GREATER HEIGHT: %.2f \n", greaterHeight);
    System.out.printf("WOMEN HEIGHT AVERAGE: %.2f \n", womenHeightSum / womenCount);
    System.out.println("MEN COUNT: " + manCount);

    scanner.close();
  }
}
