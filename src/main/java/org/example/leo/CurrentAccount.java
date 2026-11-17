package org.example.leo;

import java.time.LocalDate;
import java.util.ArrayList;

public class CurrentAccount extends BankAccount {
    private static final double DEFAULT_BALANCE = 0.0;
    private static final int LOAN_LIMIT = 850;
    private static final int MIN_SCORE = 300;
    private static final int MAX_SCORE = 850;
    private int creditScore = 350;

    //CONSTRUCTOR IMPLICIT
    public CurrentAccount() {
        super("", DEFAULT_BALANCE,"",Currency.EUR);
    }

    //CONSTRUCTOR FARA SOLD,MONEDA
    public CurrentAccount(String iban,String beneficiaryName) {
        super(iban, DEFAULT_BALANCE,beneficiaryName,Currency.EUR);
    }

    //CONSTRUCTOR EXPLICIT PARTIAL
    public CurrentAccount(String iban, double balance, String beneficiaryName, Currency currency) {
        super(iban,balance,beneficiaryName,currency);
        if (balance < 0) throw new IllegalArgumentException("Initial balance cannot be negative!");
    }

    //CONSTRUCTOR EXPLICIT COMPLET
    public CurrentAccount(String iban, double balance, String beneficiaryName, Currency currency, ArrayList<String> transactions, LocalDate dt, int creditScore,boolean isActive) {
        super(iban, balance, beneficiaryName, currency, transactions, dt,isActive);
        if (balance < 0) throw new IllegalArgumentException("Initial balance cannot be negative!");
        if (creditScore < MIN_SCORE || creditScore > MAX_SCORE)
            throw new IllegalArgumentException("Credit score must be between " + MIN_SCORE + " and " + MAX_SCORE);
        this.creditScore = creditScore;
    }

    boolean getLoanState() {
        return this.getBalance() < 0;
    }

    double creditScoreToLoanLimit() {
        return LOAN_LIMIT + this.creditScore/2.0;
    }

    @Override
    public void withdraw(double sum) {
        validateAmount(sum);
        if (getLoanState()) throw new IllegalArgumentException("Loans must be payed off");
        if (this.getBalance() - sum < -creditScoreToLoanLimit()) throw new IllegalArgumentException("Loan over loan limit");
        this.setBalance(this.getBalance() - sum);
        recordTransaction("WITHDRAWAL: " + sum + getCurrency());
        if (getLoanState()) if (this.creditScore > MIN_SCORE) creditScore = creditScore - 10;
    }

    @Override
    public void deposit(double sum) {
        validateAmount(sum);
        setBalance(getBalance() + sum);
        recordTransaction("DEPOSIT: " + sum + getCurrency());
        if (creditScore < MAX_SCORE) creditScore = creditScore + 10;
    }

    @Override
    public void setBalance(double balance) {
        if (balance < -creditScoreToLoanLimit()) throw new IllegalArgumentException("Balance is below loan limit");
        super.setBalance(balance);
    }

    public int getCreditScore() {
        return creditScore;
    }
}
