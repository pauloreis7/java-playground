package VectorsExercises.MetricPeople;

import java.util.Locale;
import java.util.Scanner;

class Person {
  private final String name;
  private final int age;
  private final double height;

  public Person(final String name, final int age, final double height) {
    this.name = name;
    this.age = age;
    this.height = height;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public double getHeight() {
    return height;
  }
}

public class MetricPeople {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the amount of people to be entered:");
    int amount = scanner.nextInt();

    double heightSum = 0;
    double underSixteenSum = 0;
    double averageHeight, underSixteenPercentage;

    Person[] peopleVector = new Person[amount];

    for (int i = 0; i < peopleVector.length; i++) {
      System.out.println();

      System.out.printf("Person %dº data:\n", i + 1);

      System.out.print("Name: ");
      String name = scanner.next();

      System.out.print("AGE: ");
      int age = scanner.nextInt();

      System.out.print("HEIGHT: ");
      double height = scanner.nextDouble();

      peopleVector[i] = new Person(name, age, height);

      heightSum += height;

      if (age < 16) {
        underSixteenSum++;
      }
    }

    averageHeight = heightSum / peopleVector.length;
    underSixteenPercentage = (underSixteenSum * 100) / peopleVector.length;

    System.out.println();

    System.out.printf("Average height: %.2f \n", averageHeight);
    System.out.printf("Under sixteen years percentage: %.1f%% \n", underSixteenPercentage);

    for (Person person : peopleVector) {
      if (person.getAge() >= 16) {
        continue;
      }

      System.out.println(person.getName());
    }

    scanner.close();
  }
}
