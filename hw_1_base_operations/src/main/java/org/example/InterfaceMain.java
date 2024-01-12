package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterfaceMain {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice = -1;

        while (choice != 0) {
            System.out.println("Select a task: ");
            System.out.println("1. Counting the sum of numbers in a string");
            System.out.println("2. Counting occurrences of each character");
            System.out.println("0. Exit");

            choice = Integer.parseInt(reader.readLine());

            switch (choice){
                case 1 -> SumNumbersTask1.sumNumbers(reader);
                case 2 -> SymbolCounterTusk2.countSymbols(reader);
                case 0 -> System.out.println("Program completed. ");
                default -> System.out.println("Incorrect choice");

            }
        }

    }
}