package org.leonard;

import java.time.LocalDate;
import java.util.ArrayList;

public class TenExamples {
    public static void loadExamples() {
        //lista de tipul clasei parinte, poate tine orice tip de cont (polimorfism)
        ArrayList<BankAccount> accounts = new ArrayList<>();

        //5 conturi curente
        //fara argumente
        CurrentAccount c1 = new CurrentAccount();
        //fara sold, moneda
        CurrentAccount c2 = new CurrentAccount("RO49BTRL0000000000000002", "Andrei Popescu");
        //partial
        CurrentAccount c3 = new CurrentAccount("RO49BTRL0000000000000003", 1200.0, "Maria Ionescu", Currency.RON);
        //complet
        CurrentAccount c4 = new CurrentAccount("RO49BTRL0000000000000004", 300.0, "Lukas Schmidt", Currency.EUR,
                new ArrayList<>(), LocalDate.of(2024, 3, 15), 720, true);
        //copiere
        CurrentAccount c5 = new CurrentAccount(c3);

        //5 conturi de economii
        //fara argumente
        EconomyAccount e1 = new EconomyAccount();
        //fara sold, moneda
        EconomyAccount e2 = new EconomyAccount("RO49INGB0000000000000007", "Elena Radu");
        //partial
        EconomyAccount e3 = new EconomyAccount("RO49INGB0000000000000008", 2500.0, "Ion Vasile", Currency.EUR);
        //complet
        EconomyAccount e4 = new EconomyAccount("RO49INGB0000000000000009", 800.0, "Sofia Marin", Currency.USD,
                LocalDate.of(2025, 1, 10), new ArrayList<>(), 12, 18, 0, true);
        //copiere
        EconomyAccount e5 = new EconomyAccount(e3);

        //operatii
        c3.deposit(250.0);
        c3.withdraw(100.0);
        // intra pe minus dar in limita de imprumut
        c4.withdraw(900.0);
        c5.deposit(50.0);
        e3.deposit(500.0);
        e3.withdraw(300.0);
        e4.withdraw(150.0);
        /*
        try {
            e2.withdraw(50.0);       // ar cobori sub soldul minim de 100
        } catch (IllegalArgumentException ex) {
            System.out.println("[EconomyAccount] Withdrawal refused: " + ex.getMessage());
        }
        try {
            c4.withdraw(10.0);       // are deja datorie
        } catch (IllegalArgumentException ex) {
            System.out.println("[CurrentAccount] Withdrawal refused: " + ex.getMessage());
        }
        */
        accounts.add(c1);
        accounts.add(c2);
        accounts.add(c3);
        accounts.add(c4);
        accounts.add(c5);
        accounts.add(e1);
        accounts.add(e2);
        accounts.add(e3);
        accounts.add(e4);
        accounts.add(e5);

        System.out.println("\n-=-=-= Print Accounts Leonard: Current & Economy Accounts =-=-=-");
        for (BankAccount account : accounts) {
            System.out.println(account);
            account.displayInterest();
        }
    }
}
