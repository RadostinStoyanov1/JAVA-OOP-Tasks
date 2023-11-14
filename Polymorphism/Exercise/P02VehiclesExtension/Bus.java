package P12Polymorphism_Exercise.P02VehiclesExtension;

public class Bus extends AbstractVehicle{
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    public String driveWithPeople(double distance) {
        double neededFuel = (super.getFuelConsumption() + 1.4) * distance;
        if (super.getFuelQuantity() < neededFuel) {
            return "Bus needs refueling";
        } else {
            setFuelQuantity(getFuelQuantity() - neededFuel);
            return String.format("Bus travelled %s km", super.DECIMAL_FORMAT.format(distance));
        }
    }
}
