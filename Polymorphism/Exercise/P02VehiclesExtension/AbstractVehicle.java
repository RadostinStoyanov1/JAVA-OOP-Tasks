package P12Polymorphism_Exercise.P02VehiclesExtension;

import java.text.DecimalFormat;

public abstract class AbstractVehicle implements Vehicle {

    protected static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.##");
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public AbstractVehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    protected double getFuelConsumption() {
        return fuelConsumption;
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    @Override
    public String drive(double distance) {
        double neededFuel = this.fuelConsumption * distance;
        if (this.fuelQuantity >= neededFuel) {
            this.fuelQuantity -= neededFuel;
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), this.DECIMAL_FORMAT.format(distance));
        }
        return String.format("%s needs refueling", this.getClass().getSimpleName());
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (this.fuelQuantity + liters > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }

}
