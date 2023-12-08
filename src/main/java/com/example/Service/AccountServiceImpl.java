package com.example.Service;

import com.example.Entitu.Account;
import com.example.Entitu.Customer;
import com.example.Entitu.Transaction;
import com.example.Enum.AccountType;
import com.example.Enum.TransactionType;
import com.example.REpositru.AccountRepositru;
import com.example.REpositru.CustomerRepositru;
import com.example.REpositru.TransactionRepositru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepositru accountRepositru;
    @Autowired
    CustomerRepositru customerRepositru;
    @Autowired
    TransactionRepositru transactionRepositru;


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

    @Override
    public void affecte(Long idCustomer, Long idAccount) {
        Customer customer=customerRepositru.findById(idCustomer).get();
        Account account=accountRepositru.findById(idAccount).get();

        account.setCustomer(customer);
        accountRepositru.save(account);






    }

    @Override
    public List<Account> getAllAccountByAccountType() {
        List<Account> accountss=new ArrayList<>();
      List<Account> accounts=accountRepositru.findAll();
     for(Account acc :accounts){
         if(acc.getAccountType().equals(AccountType.Courant)){
             accountss.add(acc);

         }
         else return  null;


     }
        return accountss;
    }

    @Override
    public Transaction addTransation(Transaction transaction,Long idacc) {
        Account account=accountRepositru.findById(idacc).get();
        transaction.setId(UUID.randomUUID().toString());
        transaction.setAccount(account);

        return transactionRepositru.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactionForCustomer(Long id) {
        List<Transaction> transactions=new ArrayList<>();
        Customer customer=customerRepositru.findById(id).get();
        for (Account account:customer.getAccounts()){
            transactions.addAll(account.getTransactions());


        }

        return transactions;
    }

    @Override
    public List<Transaction> getAllTRansationByType() {
        return transactionRepositru.findByTransactionType(TransactionType.Debit);
    }

    @Override
    public List<Transaction> getAllTrnsationByAccountId(Long id) {
        return transactionRepositru.findByAccount_Id(id);
    }
}
