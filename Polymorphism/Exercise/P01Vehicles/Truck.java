package P12Polymorphism_Exercise.P01Vehicles;

public class Truck extends AbstractVehicle{

    private static final double ADDITIONAL_SUMMER_FUEL_CONSUMPTION = 1.6;
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_SUMMER_FUEL_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
