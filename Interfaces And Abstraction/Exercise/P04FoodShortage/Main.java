package P10InheritanceAndAbstraction_Exercise.P04FoodShortage;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Buyer> buyers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            if (input.length == 3) {
                Rebel rebel = new Rebel(input[0], Integer.parseInt(input[1]), input[2]);
                buyers.add(rebel);
            } else if (input.length == 4) {
                Citizen citizen = new Citizen(input[0], Integer.parseInt(input[1]), input[2], input[3]);
                buyers.add(citizen);
            }
        }

        String command = scanner.nextLine();

        while (!"End".equals(command)) {
            for (Buyer buyer : buyers) {
                if (buyer.getName().equals(command)) {
                    buyer.buyFood();
                }
            }
            command = scanner.nextLine();
        }



        int sum = buyers.stream().mapToInt(Buyer::getFood).sum();
        System.out.println(sum);
    }
}
