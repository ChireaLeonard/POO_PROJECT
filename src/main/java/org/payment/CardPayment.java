package org.payment;

import org.card.BankCard;
import org.leonard.Currency;

import java.time.LocalDate;

public class CardPayment extends Payment {
    private BankCard card;

    public CardPayment(double amount, String beneficiary, Currency currency, BankCard card) {
        super(amount, beneficiary, currency);
        this.card = card;
    }

    public CardPayment() {
        super();
        this.card = new BankCard();
    }

    public CardPayment(double amount, String beneficiary, BankCard card) {
        this(amount, beneficiary, Currency.EUR, card);
    }

    public CardPayment(CardPayment other) {
        super(other);
        this.card = other.card == null ? null : new BankCard(other.card);
    }

    public BankCard getCard() {
        return card;
    }

    public void setCard(BankCard card) {
        this.card = card;
    }

    @Override
    public boolean validate() {
        if (amount <= 0 || card == null) {
            return false;
        }
        if (!isValidCardNumber(card.getCardNumber())) {
            return false;
        }
        return !isExpired(card.getExpirationMonth(), card.getExpirationYear());
    }

    @Override
    public double calculateTotal() {
        return amount;
    }

    private boolean isValidCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() != 16) {
            return false;
        }
        for (int i = 0; i < cardNumber.length(); i++) {
            if (!Character.isDigit(cardNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isExpired(int month, int year) {
        LocalDate today = LocalDate.now();
        if (year < today.getYear()) {
            return true;
        }
        return year == today.getYear() && month < today.getMonthValue();
    }

    @Override
    public String toString() {
        String holder = card == null ? "Unknown" : card.getCardHolder();
        return "CardPayment{" + super.toString()
                + ", holder=" + holder
                + ", total=" + String.format("%.2f", calculateTotal())
                + "}";
    }
}
