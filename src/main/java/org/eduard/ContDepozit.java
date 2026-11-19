package org.eduard;

import org.leonard.BankAccount;
import org.leonard.Currency;

public abstract class ContDepozit extends BankAccount
{
    double sumaDepusa;
    double rataDobanda;
    int durataLuni;
    double penalizareLichidare;
    Currency moneda;

    public ContDepozit()
    {
        this.sumaDepusa = 0.0;
        this.rataDobanda = 0.0;
        this.durataLuni = 0;
        this.penalizareLichidare = 0.0;
        this.moneda = Currency.EUR;
    }

    public ContDepozit(String iban, String titular, double sold, double sumaDepusa,
                       double rataDobanda, int durataLuni, double penalizareLichidare, Currency moneda)
    {
        this.sumaDepusa = sumaDepusa;
        this.rataDobanda = rataDobanda;
        this.durataLuni = durataLuni;
        this.penalizareLichidare = penalizareLichidare;
        this.moneda = moneda;
    }

    public ContDepozit(ContDepozit altCont)
    {
        this.sumaDepusa = altCont.sumaDepusa;
        this.rataDobanda = altCont.rataDobanda;
        this.durataLuni = altCont.durataLuni;
        this.penalizareLichidare = altCont.penalizareLichidare;
        this.moneda = altCont.moneda;
    }

    public void calculeazaDobanda()
    {
        double castig = sumaDepusa * (rataDobanda / 100) * (durataLuni / 12.0);
        System.out.println("Dobânda calculată pentru depozit: " + castig + " " + moneda);
    }

    @Override
    public String toString()
    {
        return super.toString() + ", Suma Depusă: " + sumaDepusa + ", Dobândă: " + rataDobanda + "%";
    }
}
