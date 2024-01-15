package org.example;

import java.io.IOException;

public class CrudMain {
    public static void main(String[] args) throws IOException {
        BicycleController bicycleController = new BicycleController();
        bicycleController.start();
    }
}