package com.kcbgroup.testapi.models;

import javax.persistence.*;


@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AccountId;
    private String Iban;
    private String BankCode;
    private int CustomerId;

    public Account(int accountid, String iban, String bankCode, int customerId) {
        AccountId = accountid;
        this.Iban = iban;
        BankCode = bankCode;
        CustomerId = customerId;
    }

    public Account() {
    }

    public int getAccountId() {
        return AccountId;
    }

    public void setAccountId(int accountId) {
        AccountId = accountId;
    }

    public String getIban() {
        return Iban;
    }

    public void setIban(String iban) {
        this.Iban = iban;
    }

    public String getBankCode() {
        return BankCode;
    }

    public void setBankCode(String bankCode) {
        BankCode = bankCode;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }
}
