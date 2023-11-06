package P08Inheritance_Exercise.restaurant.beverage;

import P08Inheritance_Exercise.restaurant.Product;

import java.math.BigDecimal;

public class Beverage extends Product {

    private double milliliters;

    public Beverage(String name, BigDecimal price, double milliliters) {
        super(name, price);
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }
}
