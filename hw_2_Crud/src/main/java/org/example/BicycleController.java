package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BicycleController {

    Bicycle[] bicycles = new Bicycle[10];
    void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        menu();
        String position = "";
        while ((position = reader.readLine()) != null) {
            crud(position,reader);
            menu();
        }
    }

    void menu() {
        System.out.println();
        System.out.println("To add a new bike enter - 1");
        System.out.println("To see the entire list of bicycles, enter - 2");
        System.out.println("To exit the program, enter - 3");
    }

    void crud(String position, BufferedReader reader) throws IOException {
        switch (position) {
            case "1" -> create(reader);
            case "2" -> readAll();
            case "3" -> System.exit(0);
        }
    }

    void create(BufferedReader reader) throws IOException {
        System.out.println("Enter your bike brand");
        String brandBike = reader.readLine();
        System.out.println("Enter your bike model");
        String modelBike = reader.readLine();
        Bicycle bicycle = new Bicycle();
        bicycle.brandBike = brandBike;
        bicycle.modelBike = modelBike;

        for(int i = 0; i < bicycles.length; i++) {
            if (bicycles[i]== null) {
                bicycles[i] = bicycle;
                break;
            }
        }
    }
    void readAll() {
        for (int i = 0; i < bicycles.length; i++) {
            if (bicycles[i] != null) {
                System.out.println("i: " + i + ", Brand bike: "
                        + bicycles[i].brandBike + ", Model bike: " + bicycles[i].modelBike);
            }
        }
    }
}
