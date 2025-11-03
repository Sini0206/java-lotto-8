package lotto.view;

import lotto.enums.ErrorMessage;
import lotto.enums.Rank;
import lotto.model.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printPurchasedLotto(List<Lotto> lottos) {
        printLottoCount(lottos);
        printLottoNumbers(lottos);
    }

    public static void printLottoCount(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        if (lottos.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NOT_EXIST.getMessage());
        }

        for (Lotto lotto: lottos) {
            lotto.validate(lotto.getNumbers());
            System.out.println(lotto.getNumbers());
        }
    }
    
    public static void printProfitRate(Double profitRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }
}
