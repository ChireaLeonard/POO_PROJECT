package org.eduard;

import org.leonard.BankAccount;
import org.leonard.Currency;

import java.util.ArrayList;

//I created a separate main class, to test and work with the ArrayList
//Also I felt as if I was going to make a bigger problem if I put this now inside the main Main

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<BankAccount> accountList = new ArrayList<>();

        for (int i=0; i<5; i++)
        {
            accountList.add(new SalaryAccount("RO"+i, "Titular "+i , 1000*i,
                    4000+i*100, 200, 5.0, "Company "+ i, 10) {
                //I didn't want to add these 2 operations, but Java forced me to
                @Override
                public void withdraw(double sum) { /**/ }

                @Override
                public void deposit(double sum) { /**/ }
            });

            accountList.add(new DepositAccount("DE"+i,"Titular "+i, 5000*i,
                    5000, 3.5, 12, 1.0, Currency.EUR) {
                //I didn't want to add these 2 operations, but Java forced me to, again...
                @Override
                public void withdraw(double sum) { /**/ }

                @Override
                public void deposit(double sum) { /**/ }
            });

            System.out.println("---Show every account---");
            for (BankAccount account : accountList) {account.calculeazaDobanda();}
        }
    }

    public static void filterAccounts(ArrayList<BankAccount> list, double minimumBalance)
    {
        //I have yet to find a way to implement currency, without creating more issues than before
        System.out.println("\n---Accounts that respect the terms and conditions---");
        for (BankAccount a : list)
            if (a.getBalance() >= minimumBalance)
                if (a instanceof DepositAccount)
                {
                    System.out.println("Found an eligible Deposit Account: " + a.getBeneficiaryName());
                }
                else if (a instanceof SalaryAccount)
                {
                    System.out.println("Found an eligible Salary Account: " + a.getBeneficiaryName());
                }
    }
}
