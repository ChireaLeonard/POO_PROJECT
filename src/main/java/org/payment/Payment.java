package org.payment;

import org.leonard.Currency;

public abstract class Payment implements PaymentOperations {
    private double amount;
    private String beneficiary;
    private Currency currency;
    private String paymentId;
    private String description;
    private String paymentDate;
    private boolean completed;

    public Payment() {
        this(0.0, "", Currency.EUR, "", "", "", false);
    }

    public Payment(double amount, String beneficiary, Currency currency, String paymentId,
                   String description, String paymentDate, boolean completed) {
        this.amount = amount;
        this.beneficiary = beneficiary;
        this.currency = currency;
        this.paymentId = paymentId;
        this.description = description;
        this.paymentDate = paymentDate;
        this.completed = completed;
    }

    public Payment(double amount, String beneficiary, Currency currency) {
        this(amount, beneficiary, currency, "", "", "", false);
    }

    public Payment(double amount, String beneficiary) {
        this(amount, beneficiary, Currency.EUR);
    }

    public Payment(Payment other) {
        this(other.amount, other.beneficiary, other.currency, other.paymentId,
                other.description, other.paymentDate, other.completed);
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public abstract boolean validate();

    @Override
    public abstract double calculateTotal();

    @Override
    public String toString() {
        return "paymentId=" + paymentId
                + ", beneficiary=" + beneficiary
                + ", description=" + description
                + ", date=" + paymentDate
                + ", amount=" + String.format("%.2f", amount)
                + " " + currency
                + ", completed=" + completed;
    }
}
