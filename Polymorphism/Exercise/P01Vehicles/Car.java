package P12Polymorphism_Exercise.P01Vehicles;

public class Car extends AbstractVehicle{
    private static final double ADDITIONAL_SUMMER_FUEL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_SUMMER_FUEL_CONSUMPTION);
    }
}
