package UniqueTeacherStudents;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import UniqueTeacherStudents.entities.Student;

public class App {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    final Set<Student> students = new HashSet<>();

    System.out.print("How many students for course A? ");
    int studentsCount = scanner.nextInt();
    System.out.println();

    for (int i = 0; i < studentsCount; i++) {
      System.out.print("Student " + (i + 1) + " id: ");
      final int id = scanner.nextInt();

      students.add(new Student(id));
    }

    System.out.println();
    System.out.print("How many students for course B? ");
    studentsCount = scanner.nextInt();

    for (int i = 0; i < studentsCount; i++) {
      System.out.print("Student " + (i + 1) + " id: ");
      final int id = scanner.nextInt();

      students.add(new Student(id));
    }

    System.out.println();
    System.out.print("How many students for course C? ");
    studentsCount = scanner.nextInt();

    for (int i = 0; i < studentsCount; i++) {
      System.out.print("Student " + (i + 1) + " id: ");
      final int id = scanner.nextInt();

      students.add(new Student(id));
    }

    System.out.println();
    System.out.println("Total students: " + students.size());

    scanner.close();
  }
}
