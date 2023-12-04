package com.example.Controller;

import com.example.Entitu.Account;
import com.example.Entitu.Customer;
import com.example.REpositru.CustomerRepositru;
import com.example.Service.AccountService;
import com.example.Service.CustomerService;
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
}
