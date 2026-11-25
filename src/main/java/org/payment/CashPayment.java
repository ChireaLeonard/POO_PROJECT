package org.payment;

import org.leonard.Currency;

public class CashPayment extends Payment {
    private double amountReceived;
    private String cashierName;
    private String receiptNumber;
    private boolean exactAmount;

    public CashPayment() {
        this(0.0, "", Currency.EUR, "", "", "", false, 0.0, "", "", false);
    }

    public CashPayment(double amount, String beneficiary, Currency currency, String paymentId,
                       String description, String paymentDate, boolean completed,
                       double amountReceived, String cashierName, String receiptNumber, boolean exactAmount) {
        super(amount, beneficiary, currency, paymentId, description, paymentDate, completed);
        this.amountReceived = amountReceived;
        this.cashierName = cashierName;
        this.receiptNumber = receiptNumber;
        this.exactAmount = exactAmount;
    }

    public CashPayment(double amount, String beneficiary, Currency currency, double amountReceived) {
        this(amount, beneficiary, currency, "", "", "", false, amountReceived, "", "", false);
    }

    public CashPayment(double amount, String beneficiary, double amountReceived) {
        this(amount, beneficiary, Currency.EUR, amountReceived);
    }

    public CashPayment(CashPayment other) {
        super(other);
        this.amountReceived = other.amountReceived;
        this.cashierName = other.cashierName;
        this.receiptNumber = other.receiptNumber;
        this.exactAmount = other.exactAmount;
    }

    public double getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(double amountReceived) {
        this.amountReceived = amountReceived;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public boolean isExactAmount() {
        return exactAmount;
    }

    public void setExactAmount(boolean exactAmount) {
        this.exactAmount = exactAmount;
    }

    public double getChange() {
        if (!validate()) {
            return 0;
        }
        return amountReceived - getAmount();
    }

    @Override
    public boolean validate() {
        if (getAmount() <= 0 || amountReceived < getAmount()) {
            return false;
        }
        if (exactAmount) {
            return amountReceived == getAmount();
        }
        return true;
    }

    @Override
    public double calculateTotal() {
        return getAmount();
    }

    @Override
    public String toString() {
        return "CashPayment{" + super.toString()
                + ", received=" + String.format("%.2f", amountReceived)
                + ", cashier=" + cashierName
                + ", receipt=" + receiptNumber
                + ", exactAmount=" + exactAmount
                + ", change=" + String.format("%.2f", getChange())
                + "}";
    }
}
