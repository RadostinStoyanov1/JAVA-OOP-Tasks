package P09InterfacesAndAbstraction.P05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Identifiable> identifiableList = new ArrayList<>();

        while (!line.equalsIgnoreCase("end")) {
            String[] tokens = line.split("\\s+");

            Identifiable identifiable;
            if (tokens.length == 2) {
                identifiable = new Robot(tokens[0], tokens[1]);
            } else {
                identifiable = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            }

            identifiableList.add(identifiable);

            line = scanner.nextLine();
        }

        String fakeIdsPattern = scanner.nextLine();

        identifiableList.stream().filter(e -> e.getId().endsWith(fakeIdsPattern)).forEach(e -> System.out.println(e.getId()));
    }
}
