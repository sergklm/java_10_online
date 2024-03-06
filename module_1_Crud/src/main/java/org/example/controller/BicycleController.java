package org.example.controller;

import org.example.service.BicycleService;
import org.example.entity.Bicycle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BicycleController {

    private final BicycleService bicycleService = new BicycleService();

    public void start() throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        menu();
        String position = "";
        while ((position = reader.readLine()) != null) {
            crud(position, reader);
            menu();
        }
    }

    void menu() {
        System.out.println();
        System.out.println("To add a new bike enter - 1");
        System.out.println("To see the entire list of bicycles, enter - 2");
        System.out.println("To exit the program, enter - 3");
    }

    public void crud(String position, BufferedReader reader) throws IOException {
        switch (position) {
            case "1" -> create(reader);
            case "2" -> readAll();
            case "3" -> System.exit(0);
        }
    }

    void create(BufferedReader reader) throws IOException {
        System.out.println("Enter your bike brand");
        String brandBike = reader.readLine();
        if (brandBike == null || !isValidBrand(brandBike)) {
            System.out.println("Incorrect brand name.");
            return;
        }

        System.out.println("Enter your bike model");
        String modelBike = reader.readLine();
        if (modelBike == null || !isValidModel(modelBike)) {
            System.out.println("Incorrect model name.");
            return;
        }

        System.out.println("Enter your bike year of manufacture");
        String yearString = reader.readLine();
        if (yearString == null || !isValidYearOfManufacture(yearString)){
            System.out.println("Incorrect year of manufacture");
            return;
        }

        int yearOfManufacture = Integer.parseInt(yearString);
        Bicycle bicycle = new Bicycle();
        bicycle.setBrandBike(brandBike);
        bicycle.setModelBike(modelBike);
        bicycle.setYearOfManufacture(yearOfManufacture);
        bicycleService.create(bicycle);
    }

    public void readAll() {
        for (Bicycle bicycle : bicycleService.findAll()) {
            if (bicycle != null) {
                System.out.println("Id - " + bicycle.getId()
                        + ", Brand bike - " + bicycle.getBrandBike()
                        + ", Model bike - " + bicycle.getModelBike()
                        + ", Yer of manufacture - " + bicycle.getYearOfManufacture());
            }
        }
    }

    private boolean isValidString(String input) {
        if (input.isEmpty()) {
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (!((currentChar >= 'а' && currentChar <= 'я') ||
                    (currentChar >= 'А' && currentChar <= 'Я') ||
                    (currentChar >= 'a' && currentChar <= 'z') ||
                    (currentChar >= 'A' && currentChar <= 'Z'))) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidBrand(String brand) {
        return isValidString(brand);
    }

    private boolean isValidModel( String model) {
        return isValidString(model);
    }

    private boolean isValidYearOfManufacture(String yearString) {
        boolean isValidInput = true;
        for (int i = 0; i < yearString.length(); i++) {
            if (!Character.isDigit(yearString.charAt(i))){
                isValidInput = false;
                break;
            }
        }

        if (isValidInput) {
            int year = Integer.parseInt(yearString);
            int currentYear = java.time.Year.now().getValue();
            if (year >= 0 && year <= currentYear) {
                return true;
            } else {
                System.out.println("Invalid year. Year should be between 0 and " + currentYear + ".");
                return false;
            }
        } else {
            System.out.println("Invalid input. Please enter the year in the correct format.");
            return false;
        }
    }
}
