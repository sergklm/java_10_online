package org.example;

public class Bicycle {
    private String brandBike;
    private String modelBike;
    private int yearOfManufacture;

    public String getBrandBike() {
        return brandBike;
    }

    public void setBrandBike(String brandBike) {
        if (brandBike == null || !isValidBrand(brandBike)) {
            System.out.println("Incorrect brand name.");
            return;
        }
        this.brandBike = brandBike;
    }

    public String getModelBike() {
        return modelBike;
    }

    public void setModelBike(String modelBike) {
        if (modelBike == null || !isValidModel(modelBike)) {
            System.out.println("Incorrect model name.");
            return;
        }
        this.modelBike = modelBike;
    }

    public  int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearString) {
        boolean isValidInput = true;
        for (int i = 0; i < yearString.length(); i++) {
            if (!Character.isDigit(yearString.charAt(i))) {
                isValidInput = false;
                break;
            }
        }

        if (isValidInput) {
            int year = Integer.parseInt(yearString);
            int currentYear = java.time.Year.now().getValue();
            if (year >= 0 && year <= currentYear) {
                this.yearOfManufacture = year;
            } else {
                System.out.println("Invalid year. Year should be between 0 and " + currentYear + ".");
            }
        } else {
            System.out.println("Invalid input. Please enter the year in the correct format.");
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
}
