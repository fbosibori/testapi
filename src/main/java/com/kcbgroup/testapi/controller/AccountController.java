package com.kcbgroup.testapi.controller;

import lombok.Generated;
import models.Account;
import org.springframework.web.bind.annotation.*;

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
    public Account getAccount(@PathVariable("accountid") int accountid){
        List<Account> accounts = new ArrayList<>();
        Account faith = new Account(1,"IBAN1", "BNK001", 200);
        Account john = new Account(2,"IBAN2", "BNK002", 300);
        accounts.add(faith);
        accounts.add(john);
        return faith;
    }
    @PostMapping
    public String addAccount(@RequestBody Account AccountToAdd){
        //TODO: Add data to db
        String iban = AccountToAdd.getIban();
        String msg = "Account "+iban+" created successfully";
        return msg;

    }
    @PutMapping(path="{accountid}")
    public String updateAccount(@RequestBody Account AccountToAdd, @PathVariable("accountid") int accountid){
        //TODO: Add data to db
        String msg = "Account "+accountid+" updated successfully";
        return msg;

    }
    @DeleteMapping(path="{accountid}")
    public String deleteAccount(@PathVariable("accountid") int accountid){
        //TODO:Delete accountid
        String msg = "Account "+accountid+" deleted successfully";
        return msg;

    }

}
