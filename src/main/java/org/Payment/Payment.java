package org.Payment;

import org.example.Moneda;

public abstract class Payment implements PaymentOperations {
    protected double amount;
    protected String beneficiary;
    protected Moneda currency;

    public Payment(double amount, String beneficiary, Moneda currency) {
        this.amount = amount;
        this.beneficiary = beneficiary;
        this.currency = currency;
    }

    public Payment() {
        this(0.0, "", Moneda.EUR);
    }

    public Payment(double amount, String beneficiary) {
        this(amount, beneficiary, Moneda.EUR);
    }

    public Payment(Payment other) {
        this(other.amount, other.beneficiary, other.currency);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Moneda getCurrency() {
        return currency;
    }

    public void setCurrency(Moneda currency) {
        this.currency = currency;
    }

    @Override
    public abstract boolean validate();

    @Override
    public abstract double calculateTotal();

    @Override
    public String toString() {
        return "beneficiary=" + beneficiary
                + ", amount=" + String.format("%.2f", amount)
                + " " + currency;
    }
}
