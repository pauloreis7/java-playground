package VectorsExercises.OlderPerson;

import java.util.Locale;
import java.util.Scanner;

class Person {
  private final String name;
  private final int age;

  public Person(final String name, final int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
}

public class OlderPerson {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the amount of people to be entered:");
    int amount = scanner.nextInt();

    String olderPersonName = "";
    int currentOlderAge = 0;
    Person[] peopleVector = new Person[amount];

    for (int i = 0; i < peopleVector.length; i++) {
      System.out.println();
      System.out.printf("Person %dº data:\n", i + 1);

      System.out.print("Name: ");
      String name = scanner.next();

      System.out.print("AGE: ");
      int age = scanner.nextInt();

      peopleVector[i] = new Person(name, age);

      if (age > currentOlderAge) {
        currentOlderAge = age;
        olderPersonName = name;
      }
    }

    System.out.println();

    System.out.println("OLDER PERSON: " + olderPersonName);

    scanner.close();
  }
}
