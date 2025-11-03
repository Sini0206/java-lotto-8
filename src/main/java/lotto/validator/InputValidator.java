package lotto.validator;

import lotto.enums.ErrorMessage;

import java.util.List;

public class InputValidator {
    public static void validateInput(String input) {
        if (input == null) { // !input.matches("\\d+")
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }
    public static int canParseToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }
}
