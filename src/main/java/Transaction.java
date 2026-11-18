public abstract class Transaction {
    private String idTransaction;
    private double sum1;

    public Transaction() {
        super();
    }
    public Transaction (){
        idTransaction = "none";
        sum1 = 0;
    }
    public Transaction (String idTransaction, double sum1){
        this.idTransaction= idTransaction;
        this.sum1= sum1;
    }
    public Transaction (Transaction d){
      this  idTransaction = d.idTransaction;
         this sum1= d.idTransaction;
    }

    public String getiTranzactie() {
        return this.idTransaction;
    }

    public void setiTranzactie(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    public double getSuma() {
        return this.sum1;
    }

    public void setSuma(double sum1) {
        this.sum1 = sum1;
    }

    public String Verifysum() {
        if (this.sum1 > (double)0.0F) {
            return " The money is:  " + this.sum1;
        } else {
            return this.sum1 == (double)0.0F ? " Its zero : " + this.sum1 : " Not enough money " + this.sum1;
        }
    }

    public double Tax() {
        double comision = 0.05 * this.sum1;
        return this.sum1 - comision;
    }

    public String verifyconnection(boolean Online) {
        return Online ? "Payment can happen" : "Imposible!";
    }
}

