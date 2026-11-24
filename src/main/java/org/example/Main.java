package org.example;

import org.george.Functions_Interface;
import org.eduard.Testing_Interface;
import org.leonard.TenExamples;

public class Main
{
    public static void main(String[] args)
    {
        TenExamples.loadExamples();
        System.out.println("\n\n");
        Testing_Interface.testing();
        System.out.println("\n\n");
        Functions_Interface.testing();
    }
}