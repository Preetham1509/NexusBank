package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam Long from, @RequestParam Long to, @RequestParam Double amount) {
        try {
            accountService.executeTransfer(from, to, amount);
            return "Transfer Successful!";
        } catch (Exception e) {
            return "Transfer Failed: " + e.getMessage();
        }
    }
}