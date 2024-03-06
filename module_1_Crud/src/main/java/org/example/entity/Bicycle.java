package org.example.entity;

public class Bicycle extends BaseEntity{
    private String brandBike;
    private String modelBike;
    private int yearOfManufacture;

    public String getBrandBike() {
        return brandBike;
    }

    public void setBrandBike(String brandBike) {
        this.brandBike = brandBike;
    }

    public String getModelBike() {
        return modelBike;
    }

    public void setModelBike(String modelBike) {
        this.modelBike = modelBike;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }
}
