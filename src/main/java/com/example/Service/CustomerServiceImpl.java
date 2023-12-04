package com.example.Service;

import com.example.Entitu.Customer;
import com.example.REpositru.CustomerRepositru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepositru customerRepositru;
    @Override
    public Customer AddCustomer(Customer customer) {
        return customerRepositru.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepositru.findAll();
    }

    @Override
    public void deletCustomer(Long id) {
        customerRepositru.deleteById(id);

    }

    @Override
    public Customer updateCustomer(Customer newCustomer, Long id) {
        Customer customer=customerRepositru.findById(id).get();
        customer.setAge(newCustomer.getAge());
        customer.setFiretane(newCustomer.getFiretane());
        customer.setUsername(newCustomer.getUsername());
        customer.setId(id);
        return customerRepositru.save(customer);
    }

    @Override
    public Customer findByAge(double age) {
        return  customerRepositru.findByAge(age);
    }

    @Override
    public Customer findByUsername(String username) {
        return customerRepositru.findByUsername(username);
    }
}
