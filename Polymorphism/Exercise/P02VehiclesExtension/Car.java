package P12Polymorphism_Exercise.P02VehiclesExtension;

public class Car extends AbstractVehicle {
    private static final double ADDITIONAL_SUMMER_FUEL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_SUMMER_FUEL_CONSUMPTION, tankCapacity);
    }
}
