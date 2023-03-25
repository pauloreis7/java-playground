package com.pauloreis;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.pauloreis.domain.entities.Person;

public class App {
    public static void main(String[] args) {
        final Person person01 = new Person("Paulo", "paulo@gmail.com");
        final Person person02 = new Person("Lucas", "lucas@gmail.com");
        final Person person03 = new Person("Marina", "marina@gmail.com");

        final EntityManagerFactory eManagerFactory = Persistence.createEntityManagerFactory("jpa-demo");

        final EntityManager entityManager = eManagerFactory.createEntityManager();

        System.out.println("\n=== Create person ===\n");
        entityManager.getTransaction().begin();

        entityManager.persist(person01);
        entityManager.persist(person02);
        entityManager.persist(person03);

        entityManager.getTransaction().commit();

        System.out.println("\n=== Find person by id ===\n");

        final Person checkPersonExists = entityManager.find(Person.class, 1);
        System.out.println(checkPersonExists);

        System.out.println("\n=== Find all person ===\n");

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
        criteria.from(Person.class);

        List<Person> people = entityManager.createQuery(criteria).getResultList();

        people.forEach(System.out::println);

        System.out.println("Done!");

        eManagerFactory.close();
        entityManager.close();
    }
}
