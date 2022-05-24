package com.kcbgroup.testapi.controller;

import com.kcbgroup.testapi.Repo.AccountRepo;
import com.kcbgroup.testapi.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/account/")
public class AccountController {

    @Autowired
    AccountRepo accountRepo;

    @GetMapping
    public List<Account> getAccounts() {
        List<Account> accounts = accountRepo.findAll();
        return accounts;
    }

    @GetMapping(path = "{accountId}")
    public ResponseEntity<?> getAccount(@PathVariable("accountId") int accountId) {
        try {
            Account account = accountRepo.getById(accountId);
            Account acc = new Account(account.getAccountId(), account.getIban(), account.getBankCode(), account.getCustomerId());
            return new ResponseEntity<>(acc, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public String addAccount(@RequestBody Account accountToAdd) {
        accountRepo.save(accountToAdd);

        String iban = accountToAdd.getIban();
        String msg = "Account " + iban + " created successfully";
        return msg;

    }

    @PutMapping(path = "{accountId}")
    @Transactional
    public ResponseEntity<?> updateAccount(@PathVariable("accountId") int accountId, @RequestBody Account newAccountDetails) {
        try {
            Account account = accountRepo.getById(accountId);
            account.setBankCode(newAccountDetails.getBankCode());
            account.setIban(newAccountDetails.getIban());

            return new ResponseEntity<>("Account details updated successfully.", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{accountId}")
    public String deleteAccount(@PathVariable("accountId") int accountId) {
        if (accountRepo.existsById(accountId)) {
            accountRepo.deleteById(accountId);
            return "Account deleted successfully";
        }
        return "Account " + accountId + " does not exist";

    }
}

