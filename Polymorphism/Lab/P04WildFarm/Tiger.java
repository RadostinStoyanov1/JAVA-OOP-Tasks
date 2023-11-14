package P11Polymorphism.P04WildFarm;

public class Tiger extends Feline{
    protected Tiger(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public boolean canEat(Food food) {
        return food.getClass().getSimpleName().equals("Meat");
    }
}
