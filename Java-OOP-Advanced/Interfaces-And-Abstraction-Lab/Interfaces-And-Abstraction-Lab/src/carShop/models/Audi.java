package carShop.models;

import carShop.interfaces.Car;
import carShop.interfaces.Rentable;

public class Audi implements Rentable{

    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;
    private Integer minRentDays;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced,
                Integer minRentDays, Double pricePerDay) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
        this.minRentDays = minRentDays;
        this.pricePerDay = pricePerDay;
    }

    public String getCountryProduced() {
        return this.countryProduced;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDays;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %s tires, min rent days: %d, price per day: %.2f",
                this.getModel(), this.getCountryProduced(), Car.TIRES,
                this.getMinRentDay(), this.getPricePerDay());
    }
}
