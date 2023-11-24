package P17ExceptionsAndErrorHandling;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class P01NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int begin = range[0];
        int end = range[1];

        System.out.printf("Range: [%d...%d]\n", begin, end);

        String input = scanner.nextLine();

        while (!validInput(input, begin, end)) {
            input = scanner.nextLine();
        }
    }

    private static boolean validInput(String input, int begin, int end) {

        Optional<Integer> number = Optional.empty();

        try {
            number = Optional.of(Integer.parseInt(input));
        } catch (NumberFormatException ignored) {
        }

        boolean numberIsValid = number.isPresent() && number.get() >= begin && number.get() <= end;

        String output = numberIsValid
                ? String.format("Valid number: %d", number.get())
                : String.format("Invalid number: %s", input);
        System.out.println(output);
        return numberIsValid;
    }
}
