package christmas.util;

public class Validator {

    public static <T extends IllegalArgumentException> void validateInteger(String value, T exception) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw exception;
        }
    }
}
