package org.example.db;

import org.example.entity.Bicycle;

public class DbBicycle {

    private Bicycle[] bicycles = new Bicycle[10];

    public void create(Bicycle bicycle) {
        if (bicycles[bicycles.length - 1] != null) {
            Bicycle[] largerBicycles = new Bicycle[20];
            System.arraycopy(bicycles, 0, largerBicycles, 0, bicycles.length);
            bicycles = largerBicycles;
        }

        for (int i = 0; i < bicycles.length; i++) {
            if (bicycles[i] == null) {
                bicycles[i] = bicycle;
                bicycle.setId(i);
                break;
            }
        }
    }

    public void update(Bicycle bicycle) {
        for (int i = 0; i < bicycles.length; i++) {
            if (bicycles[i].getId() == bicycle.getId()) {
                bicycles[i] = bicycle;
                break;
            }
        }
    }

    public void delete(int id) {
        for (int i = 0; i < bicycles.length; i++) {
            if (bicycles[i].getId() == id) {
                for (int j = i; j < bicycles.length - 1; j++) {
                    bicycles[j] = bicycles[j + i];
                }
                bicycles[bicycles.length - 1] = null;
                break;
            }
        }
    }

    public Bicycle[] findAll() { return bicycles; }

    public Bicycle findById(int id) {
        for (int i = 0; i < bicycles.length; i++) {
            if (bicycles[i].getId() == id) {
                return bicycles[i];
            }
        }
        return null;
    }
}
