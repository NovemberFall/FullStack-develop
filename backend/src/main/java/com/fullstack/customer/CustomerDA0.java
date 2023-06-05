package com.fullstack.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDA0 {
    List<Customer> selectAllCustomers();
    Optional<Customer> selectCustomerById(Integer id);
    void insertCustomer(Customer customer);
    boolean existsCustomerWithEmail(String email);
    boolean existsCustomerWithId(Integer id);
    void deleteCustomerById(Integer customerId);
    void updateCustomer(Customer update);
}
