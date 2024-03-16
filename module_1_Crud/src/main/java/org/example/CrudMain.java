package org.example;

import org.example.controller.MainController;

import java.io.IOException;


public class CrudMain {

    public static void main(String[] args) throws IOException {
        MainController mainController = new MainController();
        mainController.start();
    }
}