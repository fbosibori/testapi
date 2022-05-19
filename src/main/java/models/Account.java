package models;

public class Account {
    private int Accountid;
    private String iban;
    private String BankCode;
    private int CustomerId;

    public Account(int accountid, String iban, String bankCode, int customerId) {
        Accountid = accountid;
        this.iban = iban;
        BankCode = bankCode;
        CustomerId = customerId;
    }

    public Account() {
    }

    public int getAccountid() {
        return Accountid;
    }

    public void setAccountid(int accountid) {
        Accountid = accountid;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
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
