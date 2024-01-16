package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class SumNumbersTask1 {
    public static void sumNumbers(BufferedReader reader) throws IOException {
        System.out.print("Enter a value to calculate the sum of numbers: ");
        String input = reader.readLine();
        int sum = 0;
        int currentNum = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + Character.getNumericValue(c);
            } else if (currentNum > 0) {
                sum += currentNum;
                currentNum = 0;
            }
        }
        if (currentNum > 0) {
            sum += currentNum;
        }

        System.out.println("Sum of numbers: " + sum);
    }
}
