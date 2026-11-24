package org.leonard;

import java.time.LocalDate;
import java.util.ArrayList;

public class EconomyAccount extends BankAccount {
    //CONSTANTA PENTRU MINIM LA CONT ECONOMII
    private static final double MINIMUM_BALANCE = 100.0;
    private static final double INTEREST_COEFFICIENT = 0.06;
    private static final int MINIMUM_WITHDRAWALS = 10;
    private static final int MINIMUM_DURATION = 12;
    private static final int MAXIMUM_DURATION = 24;

    private int maxWithdrawalsPerMonth;
    private int depositDurationMonths;
    private int withdrawalsThisMonth = 0;

    //CONSTRUCTOR IMPLICIT
    public EconomyAccount() {
        super("", MINIMUM_BALANCE,"", Currency.EUR);
        this.maxWithdrawalsPerMonth = maxWithdrawal(MINIMUM_BALANCE);
        this.depositDurationMonths=depositDurationDetermination(MINIMUM_BALANCE);
    }
    //CONSTRUCTOR EXPLICIT
    public EconomyAccount(String iban, double balance, String beneficiaryName, Currency currency) {
       super(iban,balance,beneficiaryName, currency);
       if (balance < MINIMUM_BALANCE) {
            throw new IllegalArgumentException("Initial balance lower than " + MINIMUM_BALANCE);
       }
        this.maxWithdrawalsPerMonth = maxWithdrawal(balance);
        this.depositDurationMonths=depositDurationDetermination(balance);
    }

    //CONSTRUCTOR EXPLICIT FARA SOLD,MONEDA
    public EconomyAccount(String iban, String beneficiaryName) {
        super(iban, MINIMUM_BALANCE,beneficiaryName, Currency.EUR);
        this.maxWithdrawalsPerMonth = maxWithdrawal(MINIMUM_BALANCE);
        this.depositDurationMonths=depositDurationDetermination(MINIMUM_BALANCE);
    }

    //CONSTRUCTOR FULL
    public EconomyAccount(String iban, double balance, String beneficiaryName, Currency currency, LocalDate dt, ArrayList<String> transaction, int maxWithdrawalsPerMonth, int depositDurationMonths, int withdrawalsThisMonth,boolean isActive) {
        super(iban,balance,beneficiaryName,currency,transaction,dt,isActive);
        if (balance < MINIMUM_BALANCE) {
            throw new IllegalArgumentException("Initial balance lower than " + MINIMUM_BALANCE);
        }
        if (withdrawalsThisMonth > maxWithdrawalsPerMonth) throw new IllegalArgumentException("Withdrawals this month cannot be greater than maximum withdrawals");
        if (maxWithdrawalsPerMonth < 10) throw new IllegalArgumentException("Too few withdrawals!");
        if (depositDurationMonths < 12 || depositDurationMonths > 24) throw new IllegalArgumentException("Months outside of range!");
        this.maxWithdrawalsPerMonth = maxWithdrawalsPerMonth;
        this.depositDurationMonths = depositDurationMonths;
        this.withdrawalsThisMonth = withdrawalsThisMonth;

    }

    //COPY CONSTUCTOR
    public EconomyAccount(EconomyAccount other) {
        super(other);
        this.maxWithdrawalsPerMonth = other.maxWithdrawalsPerMonth;
        this.depositDurationMonths = other.depositDurationMonths;
        this.withdrawalsThisMonth = other.withdrawalsThisMonth;
    }

    private static int maxWithdrawal(double balance) {
        return Math.max((int)balance/100,MINIMUM_WITHDRAWALS);
    }

    private static int depositDurationDetermination(double balance) {
        return balance > 1000 ? MINIMUM_DURATION : MAXIMUM_DURATION;
    }

    @Override
    public void withdraw(double sum) {
        validateAmount(sum);
        if (withdrawalsThisMonth >= maxWithdrawalsPerMonth) throw new IllegalArgumentException("Maximum withdrawals this month");
        if ((getBalance() - sum) < MINIMUM_BALANCE) throw new IllegalArgumentException("Insufficient funds");
        setBalance(getBalance() - sum);
        this.withdrawalsThisMonth ++;
        recordTransaction("WITHDRAW" + sum);
    }

    @Override
    public void deposit(double sum) {
        validateAmount(sum);
        setBalance(getBalance() + sum);
        recordTransaction("DEPOSIT" + sum);
    }

    @Override
    public void setBalance(double balance) {
        if (balance < MINIMUM_BALANCE) throw new IllegalArgumentException("Insufficient funds");
        super.setBalance(balance);
    }

    public void resetMonthlyWithdrawalCount() {
        this.withdrawalsThisMonth = 0;
    }

    public int getMonthlyTransactionsCount() {
        return this.withdrawalsThisMonth;
    }

    public void setMonthlyTransactionsCount(int count) {
        if (count < 0) throw new IllegalArgumentException("Cannot have a negative nr. of transactions");
        this.withdrawalsThisMonth = count;
    }

    public int getMaxAmountOfWithdrawals() {
        return this.maxWithdrawalsPerMonth;
    }

    public void setMaxWithdrawalsPerMonth(int count) {
        if (count < MINIMUM_WITHDRAWALS) throw new IllegalArgumentException("Too few withdrawals!");
        this.maxWithdrawalsPerMonth = count;
    }

    public int getDepositDurationMonths() {
        return this.depositDurationMonths;
    }

    public void setDepositDurationMonths(int depositDurationMonths) {
        if (depositDurationMonths < MINIMUM_DURATION || depositDurationMonths > MAXIMUM_DURATION) throw new IllegalArgumentException("Months outside of range!");
        this.depositDurationMonths = depositDurationMonths;
    }

    public double annualInterest() {
        return getBalance() * INTEREST_COEFFICIENT;
    }

    @Override
    public void displayInterest() {
        System.out.println("Interest: " + annualInterest() + "\n");
    }

    @Override
    protected String extraDetails() {
        return "\nMAX WITHDRAWALS/MONTH: " + this.maxWithdrawalsPerMonth
                + " | WITHDRAWALS THIS MONTH: " + this.withdrawalsThisMonth
                + " | DEPOSIT DURATION: " + this.depositDurationMonths + " months";
    }

}

