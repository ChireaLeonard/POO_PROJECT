package org.george;

public abstract class Transaction implements TransactionOperations {
    private String idTransaction;
    private double sum1;

    public Transaction() {
        super();
    }
    
    public Transaction (String idTransaction, double sum1){
        this.idTransaction= idTransaction;
        this.sum1= sum1;
    }
    public Transaction (Transaction d){
      this.idTransaction = d.idTransaction;
         this.sum1= d.sum1;
    }

    public String getiTranzactie() {
        return this.idTransaction;
    }

    public void setiTranzactie(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    public double getSuma() {
        return this.sum1;
    }

    public void setSuma(double sum1) {
        this.sum1 = sum1;
    }

    public String verifyconnection(boolean Online) {
        return Online ? "Payment can happen" : "Imposible!";
    }
}

