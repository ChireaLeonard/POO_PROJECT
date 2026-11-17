import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public Main() {
        super();
    }

    public static void main(String[] args) {
         ArrayList<Payment> listOfPayment = new ArrayList();
        listOfPayment.add(new Payment("PL001", "RON", "Ion Popescu", (double) 150.5F));
        listOfPayment.add(new Payment("PL002", "EUR", "Maria Ionescu", (double)45.0F));
        listOfPayment.add(new Payment("PL003", "USD", "Andrei Vasilescu", 120.99));
        listOfPayment.add(new Payment("PL004", "RON", "Elena Georgescu", (double)300.0F));
        listOfPayment.add(new Payment("PL005", "GBP", "Cristian Stan", (double)89.5F));
        listOfPayment.add(new Payment("PL006", "RON", "Ana Dumitrescu", 75.2));
        listOfPayment.add(new Payment("PL007", "EUR", "Vlad Munteanu", (double)210.0F));
        listOfPayment.add(new Payment("PL008", "RON", "Ioana Radu", (double)55.0F));
        listOfPayment.add(new Payment("PL009", "USD", "Gabriel Marin", (double)340.25F));
        listOfPayment.add(new Payment("PL010", "RON", "Raluca Petrescu", 18.99));
         ArrayList<TRANSFER> ListofTransfer = new ArrayList();
        ListofTransfer.add(new TRANSFER("PL001", "RON", "Ion Popescu", 2, "RO12INGB1234", "RO98BRD5678", "TR001", (double)500.0F));
        ListofTransfer.add(new TRANSFER("PL002", "EUR", "Maria Ionescu", 24, "RO45BTRL1111", "DE89COBA2222", "TR002", (double)1200.5F));
        ListofTransfer.add(new TRANSFER("PL003", "USD", "Andrei Vasilescu", 1, "RO77RZB3333", "US44BOFA4444", "TR003", (double)300.0F));
        ListofTransfer.add(new TRANSFER("PL004", "RON", "Elena Georgescu", 5, "RO11BRD5555", "RO22INGB6666", "TR004", (double)150.0F));
        ListofTransfer.add(new TRANSFER("PL005", "GBP", "Cristian Stan", 48, "RO99BCR7777", "GB12LLOY8888", "TR005", (double)850.0F));
        ListofTransfer.add(new TRANSFER("PL006", "RON", "Ana Dumitrescu", 2, "RO33OTP9999", "RO44BTRL0000", "TR006", (double)95.0F));
        ListofTransfer.add(new TRANSFER("PL007", "EUR", "Vlad Munteanu", 24, "RO55RAIF1231", "FR76BNPA3214", "TR007", (double)2300.0F));
        ListofTransfer.add(new TRANSFER("PL008", "RON", "Ioana Radu", 1, "RO66CEC4321", "RO77BCR8765", "TR008", (double)450.0F));
        ListofTransfer.add(new TRANSFER("PL009", "USD", "Gabriel Marin", 72, "RO88GARB1357", "US11JPMO2468", "TR009", (double)5400.0F));
        ListofTransfer.add(new TRANSFER("PL010", "RON", "Raluca Petrescu", 3, "RO22VOTB2468", "RO33RZB1357", "TR010", (double)670.0F));

        for(Payment payment : listOfPayment) {
           System.out.println(payment.toString() + " Sum after tax : " + payment.Tax() + "\n" + payment.Verifysum());
        }

        for(TRANSFER transfer : ListofTransfer) {
           System.out.println(transfer.toString() + " Sum after tax : " + transfer.Tax()   + "\n" + transfer.Verifysum());
        }

        VerificareId(listOfPayment, ListofTransfer);
        AtentieSuma(listOfPayment, ListofTransfer);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                (new Interface(listOfPayment,ListofTransfer)).setVisible(true);
            }
        });
    }

    public static void VerificareId(ArrayList<Payment> p, ArrayList<TRANSFER> t) {
        System.out.println("Verify id");
        boolean suspicious = false;

        for(Payment P : p) {
            if (P.getIplata() != null && P.getIplata().length() < 5) {
                System.out.println("Suspicious payment " + P.toString());
                suspicious = true;
            }
        }

        for(TRANSFER T : t) {
            if (T.getIdT() != null && T.getIdT().length() < 5) {
                System.out.println("Suspicious TRANSFER..... " + T.toString());
                suspicious = true;
            }
        }

        if (!suspicious) {
            System.out.println("All ids are alright. No issues here");
        }

    }

    public static void AtentieSuma(ArrayList<Payment> p1, ArrayList<TRANSFER> t1) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tell me the sum of money that you are looking for");
        double sumaCautata = scanner.nextDouble();
        if (sumaCautata < (double)0.0F) {
            System.out.println("To little " + sumaCautata);
        } else {
            System.out.println("Payments of this  :" + sumaCautata + "are: ");
            boolean cautaP = false;

            for(Payment P1 : p1) {
                if (P1.getSuma1() >= sumaCautata) {
                    System.out.println(P1.toString());
                    cautaP = true;
                }
            }

            if (!cautaP) {
                System.out.println("No payments with this sum of money  !");
            }

            System.out.println("Transfers with this sum  : " + sumaCautata + "are ");
            boolean cautaT = false;

            for(TRANSFER T1 : t1) {
                if (T1.getSuma2() >= sumaCautata) {
                    System.out.println(T1.toString());
                    cautaT = true;
                }
            }

            if (!cautaT) {
                System.out.println("You dont have any transfers with this sum !");
            }

        }
    }
}
