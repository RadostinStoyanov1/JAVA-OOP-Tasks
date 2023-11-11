package P10InheritanceAndAbstraction_Exercise.P03BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Birthable> birthablesList = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "Citizen":
                    Citizen citizen = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                    birthablesList.add(citizen);
                    break;
                case "Pet":
                    Pet pet = new Pet(tokens[1], tokens[2]);
                    birthablesList.add(pet);
                    break;
            }

            input = scanner.nextLine();
        }

        String year = scanner.nextLine();
        boolean isMatch = false;

        for (Birthable birthable : birthablesList) {
            String birtableYear = birthable.getBirthDate().substring(birthable.getBirthDate().length() - 4);
            if (birtableYear.equals(year)) {
                System.out.println(birthable.getBirthDate());
                isMatch = true;
            }
        }

        if (!isMatch) {
            System.out.println("<no output>");
        }

    }
}
