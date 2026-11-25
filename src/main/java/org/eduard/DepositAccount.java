package org.eduard;

import org.leonard.BankAccount;
import org.leonard.Currency;

public abstract class DepositAccount extends BankAccount
{
    //the beginning variables:
    double depositedAmount;
    double interestRate;
    int monthLength;
    double liquidationPenalty;
    Currency moneda;

    //constructor without arguments
    public DepositAccount()
    {
        super();
        this.depositedAmount = 0.0;
        this.interestRate = 0.0;
        this.monthLength = 0;
        this.liquidationPenalty = 0.0;
        this.moneda = Currency.EUR;
    }

    //constructor with all arguments
    public DepositAccount(String iban, String beneficiaryName, double balance, double sumaDepusa,
                          double rataDobanda, int durataLuni, double penalizareLichidare, Currency moneda)
    {
        //super(iban, beneficiaryName, balance);
        this.depositedAmount = sumaDepusa;
        this.interestRate = rataDobanda;
        this.monthLength = durataLuni;
        this.liquidationPenalty = penalizareLichidare;
        this.moneda = moneda;
    }

    //copying constructor
    public DepositAccount(DepositAccount altCont)
    {
        super(altCont);
        this.depositedAmount = altCont.depositedAmount;
        this.interestRate = altCont.interestRate;
        this.monthLength = altCont.monthLength;
        this.liquidationPenalty = altCont.liquidationPenalty;
        this.moneda = altCont.moneda;
    }

    //Overrides
    @Override
    public void displayInterest()
    {
        double castig = depositedAmount * (interestRate / 100) * (monthLength / 12.0);
        System.out.println("Dobânda calculată pentru depozit: " + castig + " " + moneda);
    }

    @Override
    public String toString()
    { return super.toString() + ", Suma Depusa: " + depositedAmount + ", Dobanda: " + interestRate + "%"; }
}
