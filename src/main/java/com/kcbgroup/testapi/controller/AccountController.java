package com.kcbgroup.testapi.controller;

import lombok.Generated;
import models.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/account/")
public class AccountController {

    @GetMapping
    public List<Account> getAccounts(){
        List<Account> accounts = new ArrayList<>();
        Account faith = new Account(1,"IBAN1", "BNK001", 200);
        Account john = new Account(2,"IBAN2", "BNK002", 300);
        accounts.add(faith);
        accounts.add(john);
        return accounts;
    }
    @GetMapping(path="{accountid}")
    public Account getAccounts(@PathVariable("accountid") int accountid){
        List<Account> accounts = new ArrayList<>();
        Account faith = new Account(1,"IBAN1", "BNK001", 200);
        Account john = new Account(2,"IBAN2", "BNK002", 300);
        accounts.add(faith);
        accounts.add(john);
        return faith;
    }
}
