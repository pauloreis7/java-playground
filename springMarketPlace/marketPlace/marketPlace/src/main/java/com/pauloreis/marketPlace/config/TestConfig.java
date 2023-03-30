package com.pauloreis.marketPlace.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pauloreis.marketPlace.entities.Category;
import com.pauloreis.marketPlace.entities.Customer;
import com.pauloreis.marketPlace.entities.Order;
import com.pauloreis.marketPlace.entities.OrderItem;
import com.pauloreis.marketPlace.entities.Payment;
import com.pauloreis.marketPlace.entities.Product;
import com.pauloreis.marketPlace.entities.enums.OrderStatus;
import com.pauloreis.marketPlace.repositories.CategoryRepository;
import com.pauloreis.marketPlace.repositories.CustomerRepository;
import com.pauloreis.marketPlace.repositories.OrderItemRepository;
import com.pauloreis.marketPlace.repositories.OrderRepository;
import com.pauloreis.marketPlace.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

        @Autowired
        private CustomerRepository customerRepository;

        @Autowired
        private OrderRepository orderRepository;

        @Autowired
        private CategoryRepository categoryRepository;

        @Autowired
        private ProductRepository productRepository;

        @Autowired
        private OrderItemRepository orderItemRepository;

        @Override
        public void run(String... args) throws Exception {

                Category category01 = new Category(null, "Electronics");
                Category category02 = new Category(null, "Books");
                Category category03 = new Category(null, "Computers");

                Product product01 = new Product(null, "The Lord of the Rings",
                                "Lorem ipsum dolor sit amet, consectetur.", 90.5,
                                "http://url.com");
                Product product02 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0,
                                "http://url.com");
                Product product03 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0,
                                "http://url.com");
                Product product04 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0,
                                "http://url.com");
                Product product05 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.",
                                100.99,
                                "http://url.com");

                categoryRepository.saveAll(Arrays.asList(category01, category02, category03));
                productRepository.saveAll(Arrays.asList(product01, product02, product03, product04, product05));

                product01.getCategories().add(category02);
                product02.getCategories().add(category01);
                product02.getCategories().add(category03);
                product03.getCategories().add(category03);
                product04.getCategories().add(category03);
                product05.getCategories().add(category02);

                Customer customer01 = new Customer(null,
                                "Maria Brown", "maria@gmail.com", "988888888", "123456");
                Customer customer02 = new Customer(null,
                                "Alex Green", "alex@gmail.com", "977777777", "123456");

                Order order01 = new Order(null, Instant.parse("2023-06-20T19:53:07Z"), OrderStatus.PAID, customer01);
                Order order02 = new Order(null, Instant.parse("2023-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT,
                                customer02);
                Order order03 = new Order(null, Instant.parse("2023-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,
                                customer01);

                productRepository.saveAll(Arrays.asList(product01, product02, product03, product04, product05));
                customerRepository.saveAll(Arrays.asList(customer01, customer02));
                orderRepository.saveAll(Arrays.asList(order01, order02, order03));

                OrderItem orderItem01 = new OrderItem(order01, product01, 2, product01.getPrice());
                OrderItem orderItem02 = new OrderItem(order01, product03, 1, product03.getPrice());
                OrderItem orderItem03 = new OrderItem(order02, product03, 2, product03.getPrice());
                OrderItem orderItem04 = new OrderItem(order03, product05, 2, product05.getPrice());

                orderItemRepository.saveAll(Arrays.asList(orderItem01, orderItem02, orderItem03, orderItem04));

                Payment payment01 = new Payment(null, Instant.parse("2023-06-20T21:53:07Z"), order01);
                order01.pay(payment01);

                orderRepository.save(order01);
        }
}
