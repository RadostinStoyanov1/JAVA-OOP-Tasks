package P12Polymorphism_Exercise.P01Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        Vehicle vehicle1 = new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));

        tokens = scanner.nextLine().split("\\s+");
        Vehicle vehicle2 = new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", vehicle1);
        vehicles.put("Truck", vehicle2);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            tokens = scanner.nextLine().split("\\s+");
            Vehicle vehicle = vehicles.get(tokens[1]);
            double num = Double.parseDouble(tokens[2]);

            switch (tokens[0]) {
                case "Drive":
                    System.out.println(vehicle.drive(num));
                    break;
                case "Refuel":
                    vehicle.refuel(num);
                    break;
            }
        }

        vehicles.values().forEach(System.out::println);
    }
}
