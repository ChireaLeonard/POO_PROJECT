package org.example;

import java.util.ArrayList;

public abstract class ContBancar implements OperatiiBancare {
    protected String iban;
    protected double sold;
    protected String numeBeneficiar;
    protected Moneda moneda;
    protected ArrayList<String> tranzactii;

    //CONSTRUCTOR EXPLICIT
    public ContBancar(String iban, double sold, String numeBeneficiar, Moneda moneda) {
        this.iban = iban;
        this.sold = sold;
        this.numeBeneficiar = numeBeneficiar;
        this.moneda = moneda;
    }

    //La fel cum super() cheama un constructor din clasa parinte, this() ruleaza din clasa curenta, si face si codul
    //mai lizibil

    //CONSTRUCTOR IMPLICIT
    public ContBancar() {
        this("",0.0,"",Moneda.EUR);
    }

    //CONSTRUCTOR EXPLICIT FARA MONEDA
    public ContBancar(String iban, double sold, String numeBeneficiar) {
        this(iban,sold,numeBeneficiar,Moneda.EUR);
    }

    //CONSTRUCTOR EXPLICIT FARA MONEDA, SOLD
    public ContBancar(String iban, String numeBeneficiar) {
        this(iban,0.0,numeBeneficiar,Moneda.EUR);
    }

    //Overrides
    public abstract void calculeazaDobanda();

    public abstract void afiseazaDetalii();
}
