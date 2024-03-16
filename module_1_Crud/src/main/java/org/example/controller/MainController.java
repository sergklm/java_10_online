package org.example.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainController {

    private final BicycleController bicycleController = new BicycleController();
    private final OwnerController ownerController = new OwnerController();
    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        menu();
        String position = "";
        while ((position = reader.readLine()) != null) {
            crud(position, reader);
            menu();
        }
    }

    void menu() {
        System.out.println();
        System.out.println("If you want to start working on bicycles, enter - 1");
        System.out.println("If you want to start working on owner, enter - 2");
        System.out.println("To exit the program, enter - exit");
    }

    public void crud(String position, BufferedReader reader) throws IOException {
        switch (position) {
            case "1" -> bicycleController.start();
            case "2" -> ownerController.start();
            case "exit" -> System.exit(0);
        }
    }
}
