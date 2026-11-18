package org.example;

//import java.util.ArrayList;

public abstract class ContBancar implements OperatiiBancare
{
    protected String iban;
    protected double sold;
    protected String numeBeneficiar;
    protected Moneda moneda;
    protected ArrayList<String> tranzactii;

    //Constructro cu toti parametrii
    public ContBancar(String iban, double sold, String numeBeneficiar, Moneda moneda)
    {
        this.iban = iban;
        this.sold = sold;
        this.numeBeneficiar = numeBeneficiar;
        this.moneda = moneda;
    }

    //Constructor fara parametrii
    public ContBancar() { this("",0.0,"",Moneda.EUR); }

    //Constructror cu toti parametrii, mai putin MONEDA
    public ContBancar(String iban, double sold, String numeBeneficiar) { this(iban,sold,numeBeneficiar,Moneda.EUR); }

    //Constructror cu toti parametrii, mai putin MONEDA si SOLD
    public ContBancar(String iban, String numeBeneficiar) { this(iban,0.0,numeBeneficiar,Moneda.EUR); }

    //Constructr de copiere
    public ContBancar(ContBancar altCont)
    {
        this.iban = altCont.iban;
        this.sold = altCont.sold;
        this.numeBeneficiar = altCont.numeBeneficiar;
        this.moneda = altCont.moneda;
    }

    //Getter & Setter
    public String getIban() { return iban; }
    public void setIban(String iban) { this.iban = iban; }
    
    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }
    
    public double getSold() { return sold; }
    public void setSold(double sold) { this.sold = sold; }

    //Metode abstracte
    public abstract void calculeazaDobanda();
    public abstract void afiseazaDetalii();

    //Overrides
    @Override
    public String toString() { return "IBAN: "+ iban +"Nume Beneficiar: "+ numeBeneficiar +"Sold: "+ sold; }
}
