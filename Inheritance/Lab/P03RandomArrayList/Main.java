package P07Inheritance.P03RandomArrayList;

public class Main {
    public static void main(String[] args) {

        RandomArrayList<Integer> numbers = new RandomArrayList<>();

        numbers.add(13);
        numbers.add(42);
        numbers.add(69);
        numbers.add(73);

        System.out.println(numbers.getRandomElement());
    }
}
