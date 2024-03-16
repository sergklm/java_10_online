package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FunctionsOverString {
    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        menu();
        String position = "";
        while ((position = reader.readLine()) != null) {
            operationUser(position,reader);
            menu();
        }
    }

    public static void menu() throws IOException {
        System.out.println("1. Normal reverse term");
        System.out.println("2. Reverse the specified substring in the string");
        System.out.println("3. Reversing the term by the specified indexes");
        System.out.println("0. Exit");
    }

    public void operationUser(String position, BufferedReader reader) throws IOException {
        switch (position) {
            case "1" -> reverseString();
            case "2" -> reverseSubstring();
            case "3" -> reverseByIndices();
            case "0" -> System.exit(0);
            default -> System.out.println("Incorrect choice.");
        }
    }

    public static void reverseString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the string:");
        String input = reader.readLine();
        System.out.println("Result: " + reverse(input));
    }

    public static void reverseSubstring() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the string:");
        String input = reader.readLine();
        System.out.println("Enter substring for reverse:");
        String substring = reader.readLine();
        System.out.println("Result: " + reverse(input, substring));
    }

    public static void reverseByIndices() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the string:");
        String input = reader.readLine();
        System.out.println("Enter first index:");
        int firstIndex = Integer.parseInt(reader.readLine());
        System.out.println("Enter last index:");
        int lastIndex = Integer.parseInt(reader.readLine());
        System.out.println("Result: " + reverseText(input, firstIndex, lastIndex));
    }

    public static String reverse(String src) {
        String[] words = src.split(" ");
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            int left = 0;
            int right = chars.length - 1;
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            words[i] = new String(chars);
        }
        return String.join(" ", words);
    }

    public static String reverse(String input, String substring) {
        int startIndex = input.indexOf(substring);
        if (startIndex == -1) {
            return input;
        }
        String beforeSubstring = input.substring(0, startIndex);
        String afterSubstring = input.substring(startIndex + substring.length());
        char[] chars = substring.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        String reversedSubstring = new String(chars);
        return beforeSubstring + reversedSubstring + afterSubstring;
    }

    public static String reverseText(String src, int firstIndex, int lastIndex) {
        String[] wordsArray = src.split(" ");
        String reversedText = "";
        int currentIndex = 0;
        for (String part : wordsArray) {
            if (currentIndex <= lastIndex && currentIndex + part.length() > firstIndex) {
                int subFirstIndex = Math.max(0, firstIndex - currentIndex);
                int subLastIndex = Math.min(part.length() - 1, lastIndex - currentIndex);
                String portion = part.substring(subFirstIndex, subLastIndex + 1);
                String reversePortion = reverseString(portion);
                reversedText += part.substring(0, subFirstIndex) + reversePortion + part.substring(subLastIndex + 1);
            } else {
                reversedText += part;
            }
            currentIndex += part.length() + 1;
            if (currentIndex <= lastIndex)
                reversedText += " ";
        }
        return reversedText;
    }

    private static String reverseString(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }
}
