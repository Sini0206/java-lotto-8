package lotto.validator;

import lotto.enums.ErrorMessage;

import java.util.List;

import static lotto.validator.InputValidator.canParseToNumber;
import static lotto.validator.InputValidator.validateInput;

public class LottoValidator {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    /**
     * 로또 구입 금액 입력값 검증
     * @param input 사용자 입력 문자열
     * @return 유효하면 true, 아니면 false
     */
    public static void isValidPurchaseAmounts(String input) {
        validateInput(input);
        int amount = canParseToNumber(input);

        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MINIMUM_PURCHASE_AMOUNTS.getMessage());
        }

        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDED_BY_LOTTO_PRICE.getMessage());
        }
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_LOTTO_NUMBER_SIZE.getMessage());
        }
    }

    public static void validateRange(List<Integer> numbers) {
        ;
        for (int num : numbers) {
            if (num < LOTTO_MIN_NUMBER || num > LOTTO_MAX_NUMBER)
                throw new IllegalArgumentException(ErrorMessage.WRONG_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}
