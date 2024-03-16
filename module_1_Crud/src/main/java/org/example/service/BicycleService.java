package org.example.service;

import org.example.db.DbBicycle;
import org.example.entity.Bicycle;

public class BicycleService {

    private final DbBicycle dbBicycle = new DbBicycle();

    public void create(Bicycle bicycle) {
        if (bicycle.getBrandBike() != null && bicycle.getModelBike() != null && bicycle.getYearOfManufacture() > 0) {
            dbBicycle.create(bicycle);
        }
    }

    public void update(Bicycle bicycle) {
        Bicycle current = dbBicycle.findById(bicycle.getId());
        if (current != null) {
            dbBicycle.update(bicycle);
        }
    }

    public void delete(int id) {
        Bicycle current = dbBicycle.findById(id);
        if (current != null) {
            dbBicycle.delete(id);
        }
    }

    public Bicycle[] findAll() {
        return dbBicycle.findAll();
    }

    public Bicycle findById(int id) {
        return dbBicycle.findById(id);
    }
}
