package org.example.controller;

import org.example.service.BicycleService;
import org.example.entity.Bicycle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class BicycleController {
    private final BicycleService bicycleService = new BicycleService();

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String position = "";
        while (!position.equals("0")) {
            menu();
            position = reader.readLine();
            crud(position, reader);
        }
    }

    void menu() {
        System.out.println();
        System.out.println("To add a new bike enter - 1");
        System.out.println("To see the entire list of bicycles, enter - 2");
        System.out.println("To find a bike by id, enter - 3");
        System.out.println("To update the bike, enter - 4");
        System.out.println("To delete the bike, enter - 5");
        System.out.println("Return to the previous menu, enter - 0");
        System.out.println("To exit the program, enter - exit");
    }

    public void crud(String position, BufferedReader reader) throws IOException {
        switch (position) {
            case "1" -> create(reader);
            case "2" -> readAll();
            case "3" -> readById(reader);
            case "4" -> update(reader);
            case "5" -> delete(reader);
            case "exit" -> System.exit(0);
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
        System.out.println("New bicycle added successfully.");
    }

    private void readAll() {
        for (Bicycle bicycle : bicycleService.findAll()) {
            if (bicycle != null) {
                System.out.println("Id - " + bicycle.getId()
                        + ", Brand bike - " + bicycle.getBrandBike()
                        + ", Model bike - " + bicycle.getModelBike()
                        + ", Yer of manufacture - " + bicycle.getYearOfManufacture());
            }
        }
    }

    void readById(BufferedReader reader) throws IOException {
        System.out.println("Please enter id");
        String idString = reader.readLine();
        if (!Pattern.matches("-?\\d+", idString)) {
            System.out.println("Incorrect input. Please enter a valid ID");
            return;
        }
        int id = Integer.parseInt(idString);
        Bicycle bicycle = bicycleService.findById(id);
        if (bicycle != null) {
            System.out.println(
                    "Brand bike - " + bicycle.getBrandBike()
                            + ", Model bike - " + bicycle.getModelBike()
                            + ", Yer of manufacture - " + bicycle.getYearOfManufacture());
        } else {
            System.out.println("Bicycle not found");
        }
    }

    void update(BufferedReader reader) throws IOException {
        System.out.println("Please enter id");
        String idString = reader.readLine();
        if (!Pattern.matches("-?\\d+", idString)) {
            System.out.println("Incorrect input. Please enter a valid ID");
            return;
        }
        int id = Integer.parseInt(idString);
        Bicycle bicycle = bicycleService.findById(id);
        if (bicycle != null) {
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
            bicycle = new Bicycle();
            bicycle.setBrandBike(brandBike);
            bicycle.setModelBike(modelBike);
            bicycle.setYearOfManufacture(yearOfManufacture);
            bicycle.setId(id);
            bicycleService.update(bicycle);
        } else {
            System.out.println("Bicycle not found");
        }
    }

    public void delete(BufferedReader reader) throws IOException {
        System.out.println("Please enter id");
        String idString = reader.readLine();
        if (!Pattern.matches("-?\\d+", idString)) {
            System.out.println("Incorrect input. Please enter a valid ID");
            return;
        }
        int id = Integer.parseInt(idString);
        Bicycle bicycle = bicycleService.findById(id);
        if (bicycle != null) {
            bicycleService.delete(id);
            System.out.println("Bicycle was deleted");
        } else {
            System.out.println("Bicycle not found");
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

    private boolean isValidModel(String model) {
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
