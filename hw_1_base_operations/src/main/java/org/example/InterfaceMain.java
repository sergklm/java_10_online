package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterfaceMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SumNumbersTask1.sumNumbers(reader);
        SymbolCounterTusk2.countSymbols(reader);
        LastLessonTask3.calculateLessonEndTime(reader);
    }
}
