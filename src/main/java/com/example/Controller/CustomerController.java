package com.example.Controller;

import com.example.Entitu.Account;
import com.example.Entitu.Customer;
import com.example.Entitu.Transaction;
import com.example.REpositru.CustomerRepositru;
import com.example.Service.AccountService;
import com.example.Service.CustomerService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    AccountService accountService;
    @Autowired
    CustomerRepositru customerRepositru;
    @PostMapping("/add")
    public Customer ahadil(  @RequestBody Customer customer){
        return  customerService.AddCustomer(customer);

    }
    @GetMapping("/all")
    public List<Customer> getAll(){
        return  customerService.getAll();
    }
    @DeleteMapping("/delet/{id}")
    public  void dellet(  @PathVariable("id") Long id){
        customerService.deletCustomer(id);
    }
    @PutMapping("/mise/{id}")
    public  Customer updte( @RequestBody Customer customer, @PathVariable Long id){
      return   customerService.updateCustomer(customer,id);
    }
    @GetMapping("/serach/{x}")

    Customer findByUsername( @PathVariable("x") String username){
        return  customerService.findByUsername(username);
    }
    @PostMapping("/addacc")
    public Account add( @RequestBody Account account){
        return  accountService.addAccount(account);
    }
    @GetMapping("/allacc")
    public  List<Account> getAllhahah(){
        return  accountService.getall();
    }
    @DeleteMapping("/delettt/{id}")
    public  void delet( @PathVariable Long id){
        accountService.delet(id);
    }
    @GetMapping("/get/{id}")
    List<Account> findByCustomer_Id( @PathVariable Long id){
        Customer customer=customerRepositru.findById(id).get();
        return  customer.getAccounts();

    }
    @PostMapping("/affecte/{id}/{idacc}")
    public void AffecterCustomerToAccount( @PathVariable Long id, @PathVariable Long idacc){
        accountService.affecte(id,idacc);
    }
    @GetMapping("/gettype")
    public List<Account> getAllAccountByAccountType(){
        return  accountService.getAllAccountByAccountType();
    }
    @PostMapping("/addtrns/{id}")
    public Transaction addTransation( @RequestBody Transaction transaction, @PathVariable Long id){
        return  accountService.addTransation(transaction,id);

    }
    @GetMapping("/gett/{id}")
    public List<Transaction> getAllTransactionForCustomer( @PathVariable Long id){
        return  accountService.getAllTransactionForCustomer(id);
    }
    @GetMapping("/gettt")
    public List<Transaction> getAllTRansationByType(){
        return  accountService.getAllTRansationByType();
    }
    @GetMapping("/getttt/{id}")
    public List<Transaction> getAllTrnsationByAccountId(@PathVariable Long id){
        return  accountService.getAllTrnsationByAccountId(id);
    }

}

