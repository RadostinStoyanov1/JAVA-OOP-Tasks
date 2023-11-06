package P08Inheritance_Exercise.needForSpeed;

public class Car extends Vehicle{
    private static final double DEFAULT_FUEL_CONSUMPTION = 3.00;
    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(this.DEFAULT_FUEL_CONSUMPTION);
    }
}
