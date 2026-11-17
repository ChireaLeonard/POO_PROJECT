package org.example.leo;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class BankAccount implements BankOperations {
    private String iban;
    private double balance;
    private String beneficiaryName;
    private Currency currency;
    private ArrayList<String> transactions;
    private LocalDate openingDate;
    private boolean isActive;

    //CONSTRUCTOR IMPLICIT
    protected BankAccount() {
        this.iban = "";
        this.balance = 0.0;
        this.beneficiaryName = "";
        this.currency = Currency.EUR;
        this.transactions = new ArrayList<String>();
        this.openingDate = LocalDate.now();
        this.isActive = true;
    }

    //CONSTRUCTOR EXPLICIT COMPLET
    protected BankAccount(String iban, double balance, String beneficiaryName, Currency currency,ArrayList<String> transactions, LocalDate dt, boolean isActive) {
        if (currency == null) throw new IllegalArgumentException("Currency required");
        if (dt == null) throw new IllegalArgumentException("Opening date required");
        this.iban = iban;
        this.balance = balance;
        this.beneficiaryName = beneficiaryName;
        this.currency = currency;
        this.transactions = (transactions  == null) ? new ArrayList<String>() : new ArrayList<String>(transactions);
        this.openingDate = dt;
        this.isActive = isActive;
    }

    //CONSTRUCTOR EXPLICIT PARTIAL
    protected BankAccount(String iban, double balance, String beneficiaryName, Currency currency) {
        this.iban = iban;
        this.balance = balance;
        this.beneficiaryName = beneficiaryName;
        this.currency = currency;
        this.transactions = new ArrayList<String>();
        this.openingDate = LocalDate.now();
        this.isActive = true;
    }

    //COPY CONSTRUCTOR
    protected BankAccount(BankAccount bank) {
        this.iban = bank.iban;
        this.balance = bank.balance;
        this.beneficiaryName = bank.beneficiaryName;
        this.currency = bank.currency;
        this.transactions = (bank.transactions  == null) ? new ArrayList<String>() : new ArrayList<String>(bank.transactions);
        this.openingDate = bank.openingDate;
        this.isActive = bank.isActive;
    }

    //Final pentru a nu mai putea fi suprascrisa
    protected final void validateAmount(double sum) {
        if (sum<=0) throw new IllegalArgumentException("Sum must be positive");
    }

    protected void recordTransaction(String description) {
        transactions.add(description);
    }

    public String getIban(){
        return this.iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBeneficiaryName() {
        return this.beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public void setCurrency(Currency currency) {
        if (currency == null) throw new IllegalArgumentException("Currency required");
        this.currency = currency;
    }

    public LocalDate getOpeningDate() {
        return this.openingDate;
    }

    public void setOpeningDate(LocalDate dt) {
        if (dt == null) throw new IllegalArgumentException("Opening date required");
        this.openingDate = dt;
    }

    public ArrayList<String> getTransactions() {
        return new ArrayList<String>(this.transactions);
    }

    public void setTransactions(ArrayList<String> transactions) {
        this.transactions = (transactions == null) ? new ArrayList<String>() : new ArrayList<String>(transactions);
    }

    public boolean getActivity() {
        return this.isActive;
    }

    public void setActivity(boolean isActive) {
        this.isActive = isActive;
    }

}
