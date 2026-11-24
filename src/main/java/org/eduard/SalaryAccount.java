package org.eduard;

import org.leonard.BankAccount;

public abstract class SalaryAccount extends BankAccount
{
    //the beginning variables:
    double baseSalary;
    double bonusPerformance;
    double withdrawalFee;
    String employer;
    int payDay;

    //constructor without arguments
    public SalaryAccount()
    {
        super();
        baseSalary = 0;
        bonusPerformance = 0;
        withdrawalFee = 0;
        employer = "Unknown";
        payDay = 1;
    }

    //constructor with all arguments
    public SalaryAccount(String iban, String beneficiaryName, double balance, double salariuBaza,
                         double bonusPerformanta, double comisionRetragere, String angajator, int ziIncasare)
    {
        //super(iban, beneficiaryName, balance);
        this.baseSalary = salariuBaza;
        this.bonusPerformance = bonusPerformanta;
        this.withdrawalFee = comisionRetragere;
        this.employer = angajator;
        this.payDay = ziIncasare;
    }

    //copying constructor
    public SalaryAccount(SalaryAccount altCont)
    {
        super(altCont);
        this.baseSalary = altCont.baseSalary;
        this.bonusPerformance = altCont.bonusPerformance;
        this.withdrawalFee = altCont.withdrawalFee;
        this.employer = altCont.employer;
        this.payDay = altCont.payDay;
    }

    //Getter & setter
    public double getSalariuBaza() { return baseSalary; }
    public void setSalariuBaza() { this.baseSalary = baseSalary; }

    public double getBonusPerformanta() { return bonusPerformance; }
    public void setBonusPerformanta() { this.bonusPerformance = bonusPerformance; }

    public double getComisionRetragere() { return withdrawalFee; }
    public void setComisionRetragere() { this.withdrawalFee = withdrawalFee; }

    public String getAngajator() { return employer; }
    public void setAngajator() { this.employer = employer; }

    public int getZiIncasare() {return payDay;}
    public void setZiIncasare() { this.payDay = payDay;}

    //Overrides
    @Override
    public void displayInterest() { System.out.println("Salary account does not generate standard interest."); }

    @Override
    public String toString() {  return super.toString()+", Employer: "+ employer +", Salary: "+ baseSalary; }
}
