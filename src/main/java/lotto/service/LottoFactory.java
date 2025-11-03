package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.Collections;
import java.util.List;

import static lotto.validator.LottoValidator.*;

public class LottoFactory {
    public static Lotto createRandomLotto() {
        List<Integer> nums = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
        Collections.sort(nums);
        return new Lotto(nums);
    }

}
