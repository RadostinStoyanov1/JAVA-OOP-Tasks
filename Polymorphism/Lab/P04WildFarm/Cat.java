package P11Polymorphism.P04WildFarm;

import java.text.DecimalFormat;

public class Cat extends Feline{

    private String breed;

    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public boolean canEat(Food food) {
        return true;
    }

    @Override
    public String toString() {
        String baseString = super.toString();
        String left = baseString.substring(0, baseString.indexOf(" ") + 1);
        String right = baseString.substring(baseString.indexOf(" "));

        return left + breed + "," + right;
    }
}
