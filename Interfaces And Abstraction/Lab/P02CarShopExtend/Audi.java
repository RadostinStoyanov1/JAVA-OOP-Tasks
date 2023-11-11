package P09InterfacesAndAbstraction.P02CarShopExtend;

import java.text.DecimalFormat;

public class Audi extends CarImpl implements Rentable{

    private Integer minRentDay;
    private Double pricePerDay;
    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.000000");
        return super.toString() + System.lineSeparator() + String.format("Minimum rental period of %d days. Price per day %s", getMinRentDay(), df.format(getPricePerDay()));
    }
}
