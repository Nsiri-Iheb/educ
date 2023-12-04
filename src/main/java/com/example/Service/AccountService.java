package com.example.Service;

import com.example.Entitu.Account;

import java.util.List;

public interface AccountService {
    List<Account> findByCustomer_Id(Long id);
    public Account addAccount(Account account);
    public List<Account> getall();
    public void delet(Long id);
    public  Account update(Account account,Long id);

}
