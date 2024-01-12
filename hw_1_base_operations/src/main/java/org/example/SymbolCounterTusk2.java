package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class SymbolCounterTusk2 {
    public static void countSymbols(BufferedReader reader) throws IOException {
        System.out.print("Enter a value for the character count: ");
        String input = reader.readLine();

        int[] latinAndCyrillic = new int[128];

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= 'а' && c <= 'я') ||
                    (c >= 'А' && c <= 'Я')) {
                latinAndCyrillic[c]++;
            }
        }

        for (int i = 0; i < 128; i++) {
            if (latinAndCyrillic[i] > 0) {
                char currChar = (char) i;
                System.out.println(currChar + " - " + latinAndCyrillic[i]);
            }
        }
    }
}
