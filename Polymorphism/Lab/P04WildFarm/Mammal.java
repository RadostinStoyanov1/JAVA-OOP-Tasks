package P11Polymorphism.P04WildFarm;

public abstract class Mammal extends Animal{

    protected Mammal(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    public boolean canEat(Food food) {
        return food.getClass().getSimpleName().equals("Vegetable");
    }
}
