package com.example.Entitu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor @Data


public class Customer implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String username;
    private String firetane;
    private double age;
    @OneToMany(mappedBy ="customer")
    @JsonIgnore
    List<Account> accounts;

}
