package P11Polymorphism.P04WildFarm;

import java.text.DecimalFormat;

public abstract class Animal {

    private String animalType;
    private String animalName;
    private Double animalWeight;
    private Integer foodEaten;
    private String livingRegion;

    protected Animal(String animalType, String animalName, Double animalWeight, String livingRegion) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
        this.livingRegion = livingRegion;
    }

    public abstract void makeSound();

    public abstract boolean canEat(Food food);

    public void eat(Food food) {
        if (canEat(food)) {
            foodEaten += food.getQuantity();
        } else {
            System.out.printf("%ss are not eating that type of food!\n", getClass().getSimpleName());
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.##");
        return String.format("%s[%s, %s, %s, %d]",
                getClass().getSimpleName(),
                animalName,
                df.format(animalWeight),
                livingRegion,
                foodEaten);
    }
}
