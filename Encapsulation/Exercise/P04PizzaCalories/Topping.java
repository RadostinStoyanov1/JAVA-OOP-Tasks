package P06Encapsulation_Exercise.P04PizzaCalories;

import java.util.Map;

public class Topping {

    private static final Map<String, Double> TOPPINGS_TABLE =
            Map.of("Meat", 1.2,
                    "Veggies", 0.8,
                    "Cheese", 1.1,
                    "Sauce", 0.9);

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!TOPPINGS_TABLE.containsKey(toppingType)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories () {
        return 2 * weight * TOPPINGS_TABLE.get(toppingType);
    }

}
