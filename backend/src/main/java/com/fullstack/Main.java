package com.fullstack;

import com.fullstack.customer.Customer;
import com.fullstack.customer.CustomerRepository;
import com.github.javafaker.Faker;
import java.util.List;
import java.util.Random;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

//        printBeans(applicationContext);
    }

    // for JDBC
    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {
        return args -> {
            var faker = new Faker();
            var name = faker.name();
            String firstName = name.firstName();
            String lastName = name.lastName();
            Random random = new Random();
            Customer customer = new Customer(
                    firstName + " " + lastName,
                    firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com",
                    random.nextInt(16, 99)
            );

            customerRepository.save(customer);
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
