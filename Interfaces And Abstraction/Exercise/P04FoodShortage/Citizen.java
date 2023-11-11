package P10InheritanceAndAbstraction_Exercise.P04FoodShortage;

public class Citizen implements Person, Identifiable, Birthable, Buyer {

    private final String name;
    private final int age;
    private final String id;
    private final String birthDate;
    private int food;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
        this.food = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public void buyFood() {
        this.food = this.food + 10;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
