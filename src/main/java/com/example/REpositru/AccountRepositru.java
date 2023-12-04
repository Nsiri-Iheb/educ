package com.example.REpositru;

import com.example.Entitu.Account;
import com.example.Entitu.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepositru  extends JpaRepository<Account,Long> {
    List<Account> findByCustomer_Id(Long id);
}
