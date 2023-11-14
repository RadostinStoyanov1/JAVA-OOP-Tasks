package P11Polymorphism.P04WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Animal> animalList = new ArrayList<>();

        while (!line.equalsIgnoreCase("end")) {

            Animal animal = createAnimal(line);
            Food food = createFood(scanner.nextLine());
            animal.makeSound();
            animal.eat(food);
            animalList.add(animal);

            line = scanner.nextLine();
        }

        for (Animal animal : animalList) {
            System.out.println(animal);
        }

    }

    private static Food createFood(String s) {
        String[] tokens = s.split("\\s+");
        String foodType = tokens[0];
        Integer quantity = Integer.parseInt(tokens[1]);

        Food food;
        if (foodType.equals("Vegetable")) {
            food = new Vegetable(quantity);
        } else {
            food = new Meat(quantity);
        }

        return food;
    }

    private static Animal createAnimal(String line) {
        String[] tokens = line.split("\\s+");
        String animalType = tokens[0];
        String animalName = tokens[1];
        Double animalWeight = Double.parseDouble(tokens[2]);
        String livingRegion = tokens[3];

        Animal animal;

        if (animalType.equals("Cat")) {
            animal = new Cat(animalType, animalName, animalWeight, livingRegion, tokens[4]);
        } else if (animalType.equals("Mouse")) {
            animal = new Mouse(animalType, animalName, animalWeight, livingRegion);
        } else if (animalType.equals("Tiger")) {
            animal = new Tiger(animalType, animalName, animalWeight, livingRegion);
        } else {
            animal = new Zebra(animalType, animalName, animalWeight, livingRegion);
        }
        return animal;
    }
}
