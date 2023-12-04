package com.example.Entitu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private double amuont;
    private String type;
    @ManyToOne

    private  Customer customer;
}
