package org.Card;

public class BankCard implements IOperations {
    private String cardNumber;
    private String cardHolder;
    private int expirationMonth, expirationYear;
    private String verificationCode;
    private double funds;
    private boolean cardBlocked;

    public BankCard(){
        cardNumber = "0000000000000000";
        cardHolder = "Unknown";
        expirationMonth = 1; expirationYear = 2000;
        verificationCode = "000";
        funds = 0;
        cardBlocked = false;
    }

    public BankCard(String cardNumber, String cardHolder, int expirationMonth, int expirationYear, String verificationCode, double funds, boolean cardBlocked)
    {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expirationMonth = expirationMonth; this.expirationYear = expirationYear;
        this.verificationCode = verificationCode;
        this.funds = funds;
        this.cardBlocked = cardBlocked;
    }

    public BankCard(BankCard c)
    {
        this.cardNumber = c.cardNumber;
        this.cardHolder = c.cardHolder;
        this.expirationMonth = c.expirationMonth; this.expirationYear = c.expirationYear;
        this.verificationCode = c.verificationCode;
        this.funds = c.funds;
        this.cardBlocked = c.cardBlocked;
    }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getCardHolder() { return cardHolder; }
    public void setCardHolder(String cardHolder) { this.cardHolder = cardHolder; }

    public int getExpirationMonth() { return expirationMonth; }
    public void setExpirationMonth(int expirationMonth) { this.expirationMonth = expirationMonth; }

    public int getExpirationYear() { return expirationYear; }
    public void setExpirationYear(int expirationYear) { this.expirationYear = expirationYear; }

    public String getVerificationCode() { return verificationCode; }
    public void setVerificationCode(String verificationCode) { this.verificationCode = verificationCode; }

    public double getFunds() { return funds; }
    public void setFunds(double funds) { this.funds = funds; }
    public void decreaseFunds(double nr) { funds -= nr; }
    public void increaseFunds(double nr) { funds += nr; }

    public boolean isCardBlocked() { return cardBlocked; }
    public void setCardBlocked(boolean cardBlocked) { this.cardBlocked = cardBlocked; }

    @Override
    public boolean cardLimitReached(double sum) { return false; }

    @Override
    public boolean acceptPayment(double sum) { return false; }

    @Override
    public String toString() {
        return "BankCard{" +
                "Card Number='" + cardNumber + '\'' +
                ", Card Holder='" + cardHolder + '\'' +
                ", Expiration Month=" + expirationMonth +
                ", Expiration Year=" + expirationYear +
                ", Verification Code='" + verificationCode + '\'' +
                ", Funds=" + funds +
                ", Card Blocked=" + cardBlocked +
                '}';
    }
}
