package VectorsExercises.ApprovedStudents;

import java.util.Locale;
import java.util.Scanner;

class Student {
  private final String name;
  private final double firstSemesterGrade;
  private final double secondSemesterGrade;

  public Student(final String name, final double firstSemesterGrade, final double secondSemesterGrade) {
    this.name = name;
    this.firstSemesterGrade = firstSemesterGrade;
    this.secondSemesterGrade = secondSemesterGrade;
  }

  public String getName() {
    return name;
  }

  public double getFirstSemesterGrade() {
    return firstSemesterGrade;
  }

  public double getSecondSemesterGrade() {
    return secondSemesterGrade;
  }
}

public class ApprovedStudents {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the amount of students to be entered:");
    int amount = scanner.nextInt();

    Student[] studentsVector = new Student[amount];

    for (int i = 0; i < studentsVector.length; i++) {
      System.out.println();

      System.out.printf("Student %dº data:\n", i + 1);

      scanner.nextLine();

      System.out.print("Name: ");
      String name = scanner.nextLine();

      System.out.print("FIRST SEMESTER GRADE: ");
      double firstSemesterGrade = scanner.nextDouble();

      System.out.print("SECOND SEMESTER GRADE: ");
      double secondSemesterGrade = scanner.nextDouble();

      studentsVector[i] = new Student(name, firstSemesterGrade, secondSemesterGrade);
    }

    System.out.println();
    System.out.println("APPROVED STUDENTS:");

    for (Student student : studentsVector) {
      double finalGrade = (student.getFirstSemesterGrade() + student.getSecondSemesterGrade()) / 2;

      if (finalGrade < 6) {
        continue;
      }

      System.out.println(student.getName());
    }

    scanner.close();
  }
}
