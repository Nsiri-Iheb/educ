package com.example.REpositru;

import com.example.Entitu.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositru extends JpaRepository<Customer,Long> {
    Customer findByAge(double  age);
    Customer findByUsername(String username);
}
