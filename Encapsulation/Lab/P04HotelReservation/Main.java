package P03WorkingWithAbstraction.P04HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double price = Double.parseDouble(input[0]);
        int numDays = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2]);
        DiscountType discount = DiscountType.valueOf(input[3]);

        PriceCalculator priceCalculator = new PriceCalculator(price, numDays, season, discount);
        double calculate = priceCalculator.calculate();
        System.out.printf("%.2f%n", calculate);
    }
}
