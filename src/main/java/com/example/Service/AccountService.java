package com.example.Service;

import com.example.Entitu.Account;
import com.example.Entitu.Transaction;

import java.util.List;

public interface AccountService {
    List<Account> findByCustomer_Id(Long id);
    public Account addAccount(Account account);
    public List<Account> getall();
    public void delet(Long id);
    public  Account update(Account account,Long id);
    public void affecte(Long idCustomer,Long idAccount);
    public List<Account> getAllAccountByAccountType();
    public Transaction addTransation(Transaction transaction,Long idAccount);
    public List<Transaction> getAllTransactionForCustomer(Long id);
    public  List<Transaction> getAllTRansationByType();
    List<Transaction> getAllTrnsationByAccountId(Long id);



}
