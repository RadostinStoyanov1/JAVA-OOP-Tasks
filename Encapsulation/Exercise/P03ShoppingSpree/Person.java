package P06Encapsulation_Exercise.P03ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public void buyProduct (Product product) {
        if (product.getCost() > this.money) {
            String message = String.format("%s can't afford %s", name, product.getName());
            throw new IllegalArgumentException(message);
        }
        this.money -= product.getCost();
        products.add(product);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String productsList = this.products.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", "));
        if (this.products.isEmpty()) {
            return String.format("%s - Nothing bought", this.name);
        }
        return String.format("%s - %s", this.name, productsList);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }
}
