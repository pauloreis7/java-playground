package IntroductionToOop;

import java.util.Locale;
import java.util.Scanner;

class Student {
  private double firstQuarterGrade;
  private double secondQuarterGrade;
  private double thirdQuarterGrade;

  public Student(
      final double firstQuarterGrade,
      final double secondQuarterGrade,
      final double thirdQuarterGrade) {
    this.firstQuarterGrade = firstQuarterGrade;
    this.secondQuarterGrade = secondQuarterGrade;
    this.thirdQuarterGrade = thirdQuarterGrade;
  }

  public double finalGrade() {
    return firstQuarterGrade + secondQuarterGrade + thirdQuarterGrade;
  }

  public boolean isApproved() {
    return finalGrade() >= 60.00 ? true : false;
  }

  public double missingPoints() {
    final boolean alreadyApproved = isApproved();

    if (alreadyApproved) {
      return 0.00;
    }

    return 60.00 - finalGrade();
  }
}

public class StudentFinalGrade {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the student name: ");
    scanner.nextLine();

    System.out.println("Type the student first quarter grade: ");
    final double firstQuarterGrade = scanner.nextDouble();

    System.out.println("Type the student second quarter grade: ");
    final double secondQuarterGrade = scanner.nextDouble();

    System.out.println("Type the student third quarter grade: ");
    final double thirdQuarterGrade = scanner.nextDouble();

    final Student stundent = new Student(firstQuarterGrade, secondQuarterGrade, thirdQuarterGrade);

    System.out.printf("FINAL GRADE: %.2f \n", stundent.finalGrade());

    final boolean isApproved = stundent.isApproved();

    if (isApproved) {
      System.out.println("PASS");
    } else {
      System.out.println("FAILED");
      System.out.printf("MISSING %.2f POINTS \n", stundent.missingPoints());
    }

    scanner.close();
  }
}
