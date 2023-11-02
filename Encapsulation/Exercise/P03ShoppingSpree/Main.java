package P06Encapsulation_Exercise.P03ShoppingSpree;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Person> personsMap = new LinkedHashMap<>();
        Map<String, Product> productsMap = new LinkedHashMap<>();

        try {
            Arrays.stream(scanner.nextLine().split(";")).forEach(e -> {
                String[] tokens = e.split("=");
                Person person = new Person(tokens[0], Double.parseDouble(tokens[1]));
                personsMap.putIfAbsent(person.getName(), person);
            });

            Arrays.stream(scanner.nextLine().split(";")).forEach(e -> {
                String[] tokens = e.split("=");
                Product product = new Product(tokens[0], Double.parseDouble(tokens[1]));
                productsMap.putIfAbsent(tokens[0], product);
            });
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];

            Person person = personsMap.get(personName);
            Product product = productsMap.get(productName);

            try {
                person.buyProduct(product);
                System.out.printf("%s bought %s\n", personName, productName);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            command = scanner.nextLine();
        }

        personsMap.values().forEach(System.out::println);
    }
}
