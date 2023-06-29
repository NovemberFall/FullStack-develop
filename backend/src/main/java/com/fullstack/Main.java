package com.fullstack;

import com.fullstack.customer.Customer;
import com.fullstack.customer.CustomerRepository;
import com.fullstack.customer.Gender;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import java.util.Random;
import java.util.UUID;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

//        printBeans(applicationContext);
    }

    // for JDBC
    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            var faker = new Faker();
            Name name = faker.name();
            String firstName = name.firstName();
            String lastName = name.lastName();
            Random random = new Random();
            int age = random.nextInt(16, 99);
            Gender gender = age % 2 == 0 ? Gender.MALE : Gender.FEMALE;
            String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com";
            Customer customer = new Customer(
                    firstName + " " + lastName,
                    email,
                    passwordEncoder.encode("password"),
                    age,
                    gender);
            customerRepository.save(customer);
            System.out.println(email);
        };
    }




//    // For JPA Hibernate
//    @Bean
//    CommandLineRunner runner(CustomerRepository customerRepository) {
//        return args -> {
//            Customer alex = new Customer(
//                    "Alex",
//                    "alex@gmail.com",
//                    21
//            );
//            Customer jamila = new Customer(
//                    "Jamila",
//                    "jamila@gmail.com",
//                    19
//            );
//
//            List<Customer> customers = List.of(alex, jamila);
//            customerRepository.saveAll(customers);
//
//        };
//    }




    @Bean
    public Foo getFoo() {
        return new Foo("bar");
    }

    record Foo(String name) {
    }


    private static void printBeans(ConfigurableApplicationContext ctx) {
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
