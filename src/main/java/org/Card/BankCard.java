package org.Card;

public class BankCard implements IOperations {
    private String cardNumber;
    private String cardHolder;
    private int expirationMonth, expirationYear;
    private String verificationCode;

    public BankCard(){
        cardNumber = "0000000000000000";
        cardHolder = "Unknown";
        expirationMonth = 1; expirationYear = 2000;
        verificationCode = "000";
    }

    public BankCard(String cardNumber, String cardHolder, int expirationMonth, int expirationYear, String verificationCode)
    {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expirationMonth = expirationMonth; this.expirationYear = expirationYear;
        this.verificationCode = verificationCode;
    }

    public BankCard(BankCard c)
    {
        this.cardNumber = c.cardNumber;
        this.cardHolder = c.cardHolder;
        this.expirationMonth = c.expirationMonth; this.expirationYear = c.expirationYear;
        this.verificationCode = c.verificationCode;
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

    @Override
    public double availableFunds() { return 0; }

    @Override
    public boolean acceptPayment(double suma) { return false; }

    @Override
    public String toString() {
        return "Name: " + cardHolder + "\n" + "Card number: " + cardNumber + "\n" + "Expiration date: " + expirationMonth + "/" + expirationYear + "\n" + "Verification code: " + verificationCode;
    }
}
