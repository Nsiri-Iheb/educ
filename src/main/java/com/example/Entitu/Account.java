package com.example.Entitu;

import com.example.Enum.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private double amuont;
    private String type;
    @ManyToOne


    private  Customer customer;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @OneToMany(mappedBy ="account")
    @JsonIgnore
    private List<Transaction> transactions;
}
