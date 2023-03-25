package br.com.pauloreis.app;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import br.com.pauloreis.dao.DepartmentDao;
import br.com.pauloreis.dao.SellerDao;
import br.com.pauloreis.dao.factory.DaoFactory;
import br.com.pauloreis.entities.Department;
import br.com.pauloreis.entities.Seller;

public class App {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    final SellerDao sellerDao = DaoFactory.createSellerDao();
    final DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
    final Random random = new Random();

    System.out.println("=== SELLER - TEST 1: seller findById ===\n");
    Seller seller = sellerDao.findById(2);
    System.out.println(seller);

    System.out.println("\n === SELLER - TEST 2: seller findByDepartment ===\n");
    Department department = new Department(2, null);
    List<Seller> sellers = sellerDao.findByDepartment(department.getId());
    sellers.forEach(System.out::println);

    System.out.println("\n === SELLER - TEST 3: seller findAll ===\n");
    sellers = sellerDao.findAll();
    sellers.forEach(System.out::println);

    System.out.println("\n === SELLER - TEST 4: create seller ===\n");
    Seller newSeller = new Seller(random.nextInt(100), "Greg", "greg@gmail.com",
        LocalDate.now(), 4000.0, department);
    sellerDao.create(newSeller);
    System.out.println("Inserted! New id = " + newSeller.getId());

    System.out.println("\n === SELLER - TEST 5: seller update ===\n");
    seller = sellerDao.findById(1);
    seller.setName("Martha Waine");
    sellerDao.update(seller);
    System.out.println("Update completed");

    System.out.println("\n=== SELLER - TEST 6: seller delete ===\n");
    System.out.print("Enter seller id for delete: ");
    int id = scanner.nextInt();
    sellerDao.deleteById(id);
    System.out.println("Delete completed");

    System.out.println("=== DEPARTMENT - TEST 1: department findById ===\n");
    department = departmentDao.findById(1);
    System.out.println(department);

    System.out.println("\n === DEPARTMENT - TEST 2: department findAll ===\n");
    List<Department> departments = departmentDao.findAll();
    departments.forEach(System.out::println);

    System.out.println("\n === DEPARTMENT - TEST 3: department insert ===\n");
    Department newDepartment = new Department(random.nextInt(100), "Music");
    departmentDao.create(newDepartment);
    System.out.println("Inserted! New id: " + newDepartment.getId());

    System.out.println("\n === DEPARTMENT - TEST 4: department update ===\n");
    department = departmentDao.findById(1);
    department.setName("Food");
    departmentDao.update(department);
    System.out.println("Update completed");

    System.out.println("\n === DEPARTMENT - TEST 5: department delete ===\n");
    System.out.print("Enter department id for delete: ");
    id = scanner.nextInt();
    departmentDao.deleteById(id);
    System.out.println("Delete completed");

    scanner.close();
  }
}
