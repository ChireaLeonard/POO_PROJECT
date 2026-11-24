package org.eduard;

import org.leonard.BankAccount;
import org.leonard.Currency;

import java.util.ArrayList;

public class Testing_Interface
{
    public static void testing()
    {
        ArrayList<BankAccount> list = new ArrayList<>();

        System.out.println('\n');


        for (int i = 1; i<=10; i++)
        {
            list.add(new SalaryAccount("RO"+i, "Name: "+i, 1000*i,
                    4000+i*100, 200, 5.0, "Company "+i, 10)
            {
                @Override
                public void withdraw(double sum) {/**/}

                @Override
                public void deposit(double sum) {/**/}
            });
        }

        System.out.println("---Print Accounts---Salary Accounts---");
        for (BankAccount account : list)
        {
            System.out.println(account.toString());
        }


        System.out.println("\n\n");


        ArrayList<BankAccount> lista = new ArrayList<>();

        for (int i = 1; i<=10; i++)
        {
           lista.add(new DepositAccount("DE"+i,"Name: "+i,5000*i,
                    5000,3.5,12,1.0,Currency.EUR)
            {
                @Override
                public void withdraw(double sum) {/**/}

                @Override
                public void deposit(double sum) {/**/}
            });
        }

        System.out.println("---Print Accounts---Deposit Accounts---");
        for (BankAccount a : lista)
        {
            System.out.println(a.toString());
        }
    }
}
