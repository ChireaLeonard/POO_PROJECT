package org.example;

public class ContEconomii extends ContBancar {
    //CONSTANTA PENTRU MINIM LA CONT ECONOMII
    //static deoarece daca nu ar fi static, ar exista erori la compilare
    private static final double SOLD_ECONOMII_MINIM = 100.0;

    //CONSTRUCTOR EXPLICIT
    public ContEconomii(String iban, double sold, String numeBeneficiar, Moneda moneda) {
       super(iban,sold,numeBeneficiar,moneda);
       if (sold < SOLD_ECONOMII_MINIM) {
            throw new IllegalArgumentException("Sold initial sub minimul de " + SOLD_ECONOMII_MINIM);
       }
    }

    //CONSTRUCTOR EXPLICIT FARA SOLD,MONEDA
    public ContEconomii(String iban, String numeBeneficiar) {
        super(iban,SOLD_ECONOMII_MINIM,numeBeneficiar,Moneda.EUR);
    }

    //CONSTRUCTOR IMPLICIT
    public ContEconomii() {
       super("", SOLD_ECONOMII_MINIM,"",Moneda.EUR);
    }

    @Override
    public void retragere(double sum) {
        if (sum <= 0) {
            throw new IllegalArgumentException("Suma trebuie sa fie pozitiva");
        }
        if ((this.sold - sum) < SOLD_ECONOMII_MINIM) {
            throw new IllegalArgumentException("Fonduri insuficente");
        }
        this.sold = this.sold - sum;
    }

    @Override
    public void depunere(double sum) {
        if (sum <= 0) {
            throw new IllegalArgumentException("Suma trebuie sa fie pozitiva");
        }
        this.sold = this.sold + sum;
    }

    public double dobanda() {
        return (this.sold * 6) / 100;
    }
}
