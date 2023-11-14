package P12Polymorphism_Exercise.P02VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        for (int i = 1; i <= 3; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Vehicle vehicle;
            try {
                vehicle = createVehicle(tokens);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                vehicle = null;
            }
            if (vehicle != null) {
                vehicles.put(tokens[0], vehicle);
            }
        }

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Vehicle vehicle = vehicles.get(tokens[1]);
            double num = Double.parseDouble(tokens[2]);

            try {
                switch (tokens[0]) {
                    case "Drive":
                        if (tokens[1].equals("Bus")) {
                            Bus bus = (Bus) vehicle;
                            System.out.println(bus.driveWithPeople(num));
                        } else {
                            System.out.println(vehicle.drive(num));
                        }
                        break;
                    case "DriveEmpty":
                        System.out.println(vehicle.drive(num));
                        break;
                    case "Refuel":
                        vehicle.refuel(num);
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }


        }

        vehicles.values().forEach(System.out::println);
    }

    private static Vehicle createVehicle(String[] tokens) {
        Vehicle vehicle;
        if (tokens[0].equals("Car")) {
            vehicle = createCar(tokens);
        } else if (tokens[0].equals("Truck")) {
            vehicle = createTruck(tokens);
        } else {
            vehicle = createBus(tokens);
        }
        return vehicle;
    }

    private static Vehicle createBus(String[] tokens) {
        return new Bus(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
    }

    private static Vehicle createTruck(String[] tokens) {
        return new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
    }

    private static Vehicle createCar(String[] tokens) {
        return new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
    }
}
