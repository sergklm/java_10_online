package org.example.controller;

import org.example.CrudMain;
import org.example.entity.Bicycle;
import org.example.service.OwnerService;
import org.example.entity.Owner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class OwnerController {

    private final OwnerService ownerService = new OwnerService();

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
        System.out.println("To add a new owner enter - 1");
        System.out.println("To see the entire list of owner, enter - 2");
        System.out.println("To find a owner by id, enter - 3");
        System.out.println("To update the owner, enter - 4");
        System.out.println("To delete the owner, enter - 5");
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
        System.out.println("Enter your last name");
        String lastName = reader.readLine();
        if (lastName == null || !isValidLastName(lastName)) {
            System.out.println("Incorrect last name.");
            return;
        }

        System.out.println("Enter your first name");
        String firstName = reader.readLine();
        if (firstName == null || !isValidFirstName(firstName)) {
            System.out.println("Incorrect first name.");
            return;
        }

        Owner owner = new Owner();
        owner.setLastname(lastName);
        owner.setFirstname(firstName);
        ownerService.create(owner);
    }

    private void readAll() {
        for (Owner owner : ownerService.findAll()) {
            if (owner != null) {
                System.out.println("Id - " + owner.getId()
                        + ", Last name - " + owner.getLastname()
                        + ", First name - " + owner.getFirstname());
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
        Owner owner = ownerService.findById(id);
        if (owner != null) {
            System.out.println("Last name - " + owner.getLastname()
                    + ", First name - " + owner.getFirstname());
        } else {
            System.out.println("Owner not found");
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
        Owner owner = ownerService.findById(id);
        if (owner != null) {
            System.out.println("Enter your last name");
            String lastName = reader.readLine();
            if (lastName == null || !isValidLastName(lastName)) {
                System.out.println("Incorrect last name.");
                return;
            }

            System.out.println("Enter your first name");
            String firstName = reader.readLine();
            if (firstName == null || !isValidFirstName(firstName)) {
                System.out.println("Incorrect first name.");
                return;
            }

            owner = new Owner();
            owner.setLastname(lastName);
            owner.setFirstname(firstName);
            owner.setId(id);
            ownerService.update(owner);
        } else {
            System.out.println("Owner not found");
        }
    }

    void delete(BufferedReader reader) throws IOException {
        System.out.println("Please enter id");
        String idString = reader.readLine();
        if (!Pattern.matches("-?\\d+", idString)) {
            System.out.println("Incorrect input. Please enter a valid ID");
            return;
        }
        int id = Integer.parseInt(idString);
        ownerService.delete(id);
        Owner owner = ownerService.findById(id);
        if (owner == null) {
            System.out.println("Owner was deleted");
        } else {
            System.out.println("Owner not found");
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

    private boolean isValidLastName(String lastName) {
        return isValidString(lastName);
    }

    private boolean isValidFirstName(String firstName) {
        return isValidString(firstName);
    }
}
