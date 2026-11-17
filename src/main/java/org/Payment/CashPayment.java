package org.Payment;

import org.example.Moneda;

public class CashPayment extends Payment {
    private double amountReceived;

    public CashPayment(double amount, String beneficiary, Moneda currency, double amountReceived) {
        super(amount, beneficiary, currency);
        this.amountReceived = amountReceived;
    }

    public CashPayment() {
        super();
        this.amountReceived = 0.0;
    }

    public CashPayment(double amount, String beneficiary, double amountReceived) {
        this(amount, beneficiary, Moneda.EUR, amountReceived);
    }

    public CashPayment(CashPayment other) {
        super(other);
        this.amountReceived = other.amountReceived;
    }

    public double getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(double amountReceived) {
        this.amountReceived = amountReceived;
    }

    public double getChange() {
        if (!validate()) {
            return 0;
        }
        return amountReceived - amount;
    }

    @Override
    public boolean validate() {
        return amount > 0 && amountReceived >= amount;
    }

    @Override
    public double calculateTotal() {
        return amount;
    }

    @Override
    public String toString() {
        return "CashPayment{" + super.toString()
                + ", received=" + String.format("%.2f", amountReceived)
                + ", change=" + String.format("%.2f", getChange())
                + "}";
    }
}
