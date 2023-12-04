package com.example.Service;

import com.example.Entitu.Customer;

import java.util.List;

public interface CustomerService {
    public Customer AddCustomer(Customer customer);
    public List<Customer> getAll();
    public void deletCustomer(Long id);
    public  Customer updateCustomer(Customer newCustomer,Long id);
    Customer findByAge(double  age);
    Customer findByUsername(String username);
}
