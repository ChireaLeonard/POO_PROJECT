package org.george;

import org.leonard.Currency;

public class TRANSFER extends Payment {
    private int timeoftransfer;
    private String accs;
    private String accd;
    private String idT;
    private double sum3;

    public int getTimptransfer() {
        return this.timeoftransfer;
    }

    public void setTimptransfer(int timeoftransfer) {
        this.timeoftransfer = timeoftransfer;
    }

    public String getConts() {
        return this.accs;
    }

    public void setConts(String accs) {
        this.accs = accs;
    }

    public String getContd() {
        return this.accd;
    }

    public void setContd(String accd) {
        this.accd = accd;
    }

    public String getIdT() {
        return this.idT;
    }

    public void setIdT(String idT) {
        this.idT = idT;
    }

    public double getSuma2() {
        return this.sum3;
    }

    public void setSuma2(double sum3) {
        this.sum3 = sum3;
    }

    public TRANSFER() {
        super();
        this.timeoftransfer = 0;
        this.accs = "Not him ";
        this.accd = "Its not him ";
        this.idT = "No id";
        this.sum3 = (double)0.0F;
    }

    public TRANSFER(String idpayment, Currency currency, String nameuser, int timeoftransfer, String accs, String accd, String idT, double sum3) {
        super(idpayment,currency, nameuser, sum3);
        this.timeoftransfer = timeoftransfer;
        this.accs = accs;
        this.accd = accd;
        this.idT = idT;
        this.sum3 = sum3;
    }



    public TRANSFER(TRANSFER c) {
        super(c);
        this.timeoftransfer = c.timeoftransfer;
        this.accs = c.accs;
        this.accd = c.accd;
        this.idT = c.idT;
        this.sum3 = c.sum3;
    }
    @Override
    public double Tax() {
        double comision = 0.1 * this.sum3;
        return this.sum3 - comision;
    }
    @Override
    public String toString() {
        return "Time of transfer:" + this.timeoftransfer + "Account source of the transfer :" + this.accs + "Account destination of the transfer:" + this.accd + "Id of the transfer is :" + this.idT + "Sum of the money for the transfer is :" + this.sum3;
    }
    @Override
    public String Verifysum() {
        if (this.sum3 > (double)0.0F) {
            return " The money is : " + this.sum3;
        } else {
            return this.sum3 == (double)0.0F ? " Its zero " + this.sum3 : " Not enough money " + this.sum3;
        }
    }
}
