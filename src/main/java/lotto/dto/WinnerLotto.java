package lotto.dto;

import java.util.List;

public record WinnerLotto(
        List<Integer> lottoNumbers,
        int bonusNumber
) {
}