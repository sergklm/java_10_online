package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class SymbolCounterTusk2 {
    public static void countSymbols(BufferedReader reader) throws IOException {
        System.out.print("Enter a value for the character count: ");
        String input = reader.readLine();

        for (char c = 'a'; c <= 'z'; c++) {
            int count = countCharacter(input, c);
            if(count > 0) {
                System.out.println(c + " - " + count);
            }
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            int count = countCharacter(input, c);
            if(count > 0) {
                System.out.println(c + " - " + count);
            }
        }
        for (char c = 'а'; c <= 'я'; c++) {
            int count = countCharacter(input, c);
            if(count > 0) {
                System.out.println(c + " - " + count);
            }
        }
        for (char c = 'А'; c <= 'Я'; c++) {
            int count = countCharacter(input, c);
            if(count > 0) {
                System.out.println(c + " - " + count);
            }
        }
    }

    public static int countCharacter(String input, char targetChar) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == targetChar) {
                count++;
            }
        }
        return count;
    }
}
