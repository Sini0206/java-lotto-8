package lotto.service;

import static lotto.validator.LottoValidator.LOTTO_PRICE;

public class LottoCalculator {
    public static int calculateLottoAmount(int purchaseAmounts) {
        return purchaseAmounts / LOTTO_PRICE;
    }
}
