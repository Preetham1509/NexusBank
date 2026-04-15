package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table; // Uncommented!
import lombok.Data;

@Entity
@Table(name = "accounts") // This links to your PostgreSQL table!
@Data
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "account_number") // Explicitly mapping the column
    private String accountNumber;
    
    @Column(name = "holder_name") // Linking your Java variable to the SQL column
    private String accountHolderName;
    
    private Double balance;
    
    // Core Java Logic: Simple validation
    public void withdraw(Double amount) {
        if (amount > this.balance) {
            throw new RuntimeException("Insufficient Funds!");
        }
        this.balance -= amount;
    }
}