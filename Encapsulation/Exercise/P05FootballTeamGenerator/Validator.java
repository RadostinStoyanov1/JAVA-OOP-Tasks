//package P06Encapsulation_Exercise.P05FootballTeamGenerator;

public class Validator {

    private Validator() {
    }

    public static void validateString(String str) {
        validateString(str, "Name cannot be empty");
    }

    public static void validateString(String str, String message) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }
}
