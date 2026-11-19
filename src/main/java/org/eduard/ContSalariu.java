package org.eduard;

import org.leonard.BankAccount;

public abstract class ContSalariu extends BankAccount
{   //SalaryAccount
    //variabilele de inceput: || the beginning variables:
    double salariuBaza;        // || baseSalary
    double bonusPerformanta;   // || bonusPerformance
    double comisionRetragere;  // ||
    String angajator;          // ||
    int ziIncasare;            // || payDay

    //Constructor fara argumente || constructor without arguments
    public ContSalariu()
    {
        salariuBaza = 0;
        bonusPerformanta = 0;
        comisionRetragere = 0;
        angajator = "Unknown";
        ziIncasare = 1;
    }

    //Constructor cu toate argumentele || constructor with all arguments
    public ContSalariu(String iban, String titular, double sold, double salariuBaza,
                       double bonusPerformanta, double comisionRetragere, String angajator, int ziIncasare)
    {
        this.salariuBaza = salariuBaza;
        this.bonusPerformanta = bonusPerformanta;
        this.comisionRetragere = comisionRetragere;
        this.angajator = angajator;
        this.ziIncasare = ziIncasare;
    }

    //Constructor de copiere || copying constructor
    public ContSalariu(ContSalariu altCont)
    {
        this.salariuBaza = altCont.salariuBaza;
        this.bonusPerformanta = altCont.bonusPerformanta;
        this.comisionRetragere = altCont.comisionRetragere;
        this.angajator = altCont.angajator;
        this.ziIncasare = altCont.ziIncasare;
    }

    //Getter & setter
    public double getSalariuBaza() { return salariuBaza; }
    public void setSalariuBaza() { this.salariuBaza = salariuBaza; }

    public double getBonusPerformanta() { return bonusPerformanta; }
    public void setBonusPerformanta() { this.bonusPerformanta = bonusPerformanta; }

    public double getComisionRetragere() { return comisionRetragere; }
    public void setComisionRetragere() { this.comisionRetragere = comisionRetragere; }

    public String getAngajator() { return angajator; }
    public void setAngajator() { this.angajator = angajator; }

    public int getZiIncasare() {return ziIncasare;}
    public void setZiIncasare() { this.ziIncasare = ziIncasare;}

    public void calculeazaDobanda() {
        System.out.println("Contul de salariu nu genereaza dobanda standard.");
    }
}
