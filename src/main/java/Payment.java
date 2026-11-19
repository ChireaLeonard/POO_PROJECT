public class Payment extends Transaction {
    private String idpayment;
    private String  currency;
    private String nameuser;
    private double sum2;

    public double getSuma1() {
        return this.sum2;
    }

    public void setSuma1(double sum2) {
        this.sum2 = sum2;
    }

    public String getNumeu() {
        return this.nameuser;
    }

    public void setNumeu(String nameuser) {
        this.nameuser = nameuser;
    }

    public String getMon() {
        return this.currency;
    }

    public void setMon(String currency) {
        this.currency = currency;
    }

    public String getIplata() {
        return this.idpayment;
    }

    public void setIplata(String idpayment) {
        this.idpayment = idpayment;
    }

    public Payment() {
        super();
        this.idpayment = "Nonexistent";
        this.currency = "No currency?";
        this.nameuser = "";
        this.sum2 = (double)0.0F;
    }

    public Payment(String idpayment, String currency, String nameuser, double sum2) {
        super();
        this.idpayment = idpayment;
        this.currency = currency;
        this.nameuser = nameuser;
        this.sum2 = sum2;
    }

    public Payment(Payment a) {
        super();
        this.idpayment = a.idpayment;
        this.currency = a.currency;
        this.nameuser = a.nameuser;
        this.sum2 = a.sum2;
    }
    @Override
    public double Tax() {
        double comision = 0.2 * this.sum2;
        return this.sum2 - comision;
    }

    public String toString() {
        return "Id of the payment :" + this.idpayment + "Currency:" + this.currency + " Name of the user:" + this.nameuser + " The sum is :" + this.sum2;
    }
    @Override
    public String Verifysum() {
        if (this.sum2 > (double)0.0F) {
            return " The money is:  " + this.sum2;
        } else {
            return this.sum2 == (double)0.0F ? " Its zero  " + this.sum2 : " Not enough money " + this.sum2;
        }
    }
}
