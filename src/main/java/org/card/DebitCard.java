package org.card;

import org.leonard.Currency;

public class DebitCard extends BankCard {
    private String swiftCode;
    private Currency mainCurrency;
    private double cardLimit;

    public DebitCard()
    {
        super();
        swiftCode = "AAAAAAAAAAA";
        mainCurrency = Currency.EUR;
        cardLimit = 0;
    }

    public DebitCard(String cardNumber, String cardHolder, int expirationMonth, int expirationYear, String verificationCode,double funds, boolean cardBlocked, String swiftCode, Currency mainCurrency, double cardLimit)
    {
        super(cardNumber,cardHolder,expirationMonth,expirationYear,verificationCode,funds,cardBlocked);
        this.swiftCode = swiftCode;
        this.mainCurrency = mainCurrency;
        this.cardLimit = cardLimit;
    }

    public DebitCard(DebitCard d)
    {
        super(d);
        swiftCode = d.swiftCode;
        mainCurrency = d.mainCurrency;
        cardLimit = d.cardLimit;
    }

    public String getSwiftCode() { return swiftCode; }
    public void setSwiftCode(String swiftCode) { this.swiftCode = swiftCode; }

    public Currency getMainCurrency() { return mainCurrency; }
    public void setMainCurrency(Currency mainCurrency) { this.mainCurrency = mainCurrency; }

    public double getCardLimit() { return cardLimit; }
    public void setCardLimit(double cardLimit) { this.cardLimit = cardLimit; }

    @Override
    public boolean acceptPayment(double sum)
    {
        double funds = getFunds();
        if (sum <= funds && !isCardBlocked())
        {
            decreaseFunds(sum);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean cardLimitReached(double sum) {
        if (sum >= cardLimit)
        {
            setCardBlocked(true);
            return true;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        return "Debit Card{" +
                "Swift Code='" + swiftCode + '\'' +
                ", Currency='" + mainCurrency + '\'' +
                ", Card Limit=" + cardLimit +
                "} " + super.toString();
    }
}
