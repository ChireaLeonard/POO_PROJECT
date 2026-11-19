package org.card;

public class CreditCard extends BankCard{
    private double maximumFunds;

    public CreditCard() {
        super();
        maximumFunds = 0;
    }

    public CreditCard(String cardNumber, String cardHolder, int expirationMonth, int expirationYear, String verificationCode, double remainingFunds, boolean cardBlocked, double maximumFunds) {
        super(cardNumber, cardHolder, expirationMonth, expirationYear, verificationCode, remainingFunds, cardBlocked);
        this.maximumFunds = maximumFunds;
    }

    public CreditCard(CreditCard c) {
        super(c);
        this.maximumFunds = c.maximumFunds;
    }

    public double getMaximumFunds() { return maximumFunds; }
    public void setMaximumFunds(double maximumFunds) { this.maximumFunds = maximumFunds; }

    @Override
    public boolean cardLimitReached(double sum) {
        if (getFunds() >= maximumFunds)
        {
            setCardBlocked(true);
            return true;
        }
        else
            return false;
    }

    // Funds is used to count how much money has been used out of the total of maximumFunds
    @Override
    public boolean acceptPayment(double sum)
    {
        cardLimitReached(getFunds());
        if (sum <= getFunds() && !isCardBlocked())
        {
            increaseFunds(sum);
            return true;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "maximumFunds=" + maximumFunds +
                "} " + super.toString();
    }
}
