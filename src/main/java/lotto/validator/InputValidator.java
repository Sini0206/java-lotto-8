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

    public static int validateBonusNumber(String input, List<Integer> numbers) {
        validateInput(input);
        int bonus = canParseToNumber(input);

        for (int num : numbers) {
            if (bonus == num) {
                throw new IllegalArgumentException(ErrorMessage.CAN_NOT_MATCH_BONUS_NUMBER.getMessage());
            }
        }

        return bonus;
    }
}
