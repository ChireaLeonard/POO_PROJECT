package org.payment;

import org.card.BankCard;
import org.leonard.Currency;

import java.time.LocalDate;

public class CardPayment extends Payment {
    private BankCard card;
    private String authorizationCode;
    private int installments;
    private boolean contactless;

    public CardPayment() {
        this(0.0, "", Currency.EUR, "", "", "", false, new BankCard(), "", 1, false);
    }

    public CardPayment(double amount, String beneficiary, Currency currency, String paymentId,
                       String description, String paymentDate, boolean completed,
                       BankCard card, String authorizationCode, int installments, boolean contactless) {
        super(amount, beneficiary, currency, paymentId, description, paymentDate, completed);
        this.card = card;
        this.authorizationCode = authorizationCode;
        this.installments = installments;
        this.contactless = contactless;
    }

    public CardPayment(double amount, String beneficiary, Currency currency, BankCard card) {
        this(amount, beneficiary, currency, "", "", "", false, card, "", 1, false);
    }

    public CardPayment(double amount, String beneficiary, BankCard card) {
        this(amount, beneficiary, Currency.EUR, card);
    }

    public CardPayment(CardPayment other) {
        super(other);
        this.card = other.card == null ? null : new BankCard(other.card);
        this.authorizationCode = other.authorizationCode;
        this.installments = other.installments;
        this.contactless = other.contactless;
    }

    public BankCard getCard() {
        return card;
    }

    public void setCard(BankCard card) {
        this.card = card;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public int getInstallments() {
        return installments;
    }

    public void setInstallments(int installments) {
        this.installments = installments;
    }

    public boolean isContactless() {
        return contactless;
    }

    public void setContactless(boolean contactless) {
        this.contactless = contactless;
    }

    @Override
    public boolean validate() {
        if (getAmount() <= 0 || card == null || installments < 1) {
            return false;
        }
        if (!isValidCardNumber(card.getCardNumber())) {
            return false;
        }
        return !isExpired(card.getExpirationMonth(), card.getExpirationYear());
    }

    @Override
    public double calculateTotal() {
        return getAmount();
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
                + ", authorizationCode=" + authorizationCode
                + ", installments=" + installments
                + ", contactless=" + contactless
                + ", total=" + String.format("%.2f", calculateTotal())
                + "}";
    }
}
