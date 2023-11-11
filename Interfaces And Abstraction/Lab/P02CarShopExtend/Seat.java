package P09InterfacesAndAbstraction.P02CarShopExtend;

import java.text.DecimalFormat;

public class Seat extends CarImpl implements Sellable{

    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }


    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.000000");
        return super.toString() + System.lineSeparator() + String.format("%s sells for %s", this.getModel(), df.format(getPrice()));
    }
}
