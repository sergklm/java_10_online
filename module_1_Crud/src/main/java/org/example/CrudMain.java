package org.example;

import org.example.controller.BicycleController;

import javax.imageio.IIOException;
import java.io.IOException;

public class CrudMain {

    public static void main(String[] args) throws IOException {
        BicycleController bicycleController = new BicycleController();
        bicycleController.start();
    }
}