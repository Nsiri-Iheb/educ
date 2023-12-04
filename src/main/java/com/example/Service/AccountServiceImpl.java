package com.example.Service;

import com.example.Entitu.Account;
import com.example.REpositru.AccountRepositru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepositru accountRepositru;

    @Override
    public List<Account> findByCustomer_Id(Long id) {
        return accountRepositru.findByCustomer_Id(id);
    }

    @Override
    public Account addAccount(Account account) {
        return accountRepositru.save(account);
    }

    @Override
    public List<Account> getall() {
        return accountRepositru.findAll();
    }

    @Override
    public void delet(Long id) {
        accountRepositru.deleteById(id);

    }

    @Override
    public Account update(Account account, Long id) {
        Account account1=accountRepositru.findById(id).get();
        account1.setAmuont(account.getAmuont());
        account1.setId(id);
        account1.setType(account.getType());

        return accountRepositru.save(account);
    }
}
