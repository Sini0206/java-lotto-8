package lotto.controller;

import lotto.enums.Rank;
import lotto.model.Lotto;
import lotto.dto.WinnerLotto;
import lotto.service.LottoCalculator;
import lotto.service.LottoFactory;
import lotto.validator.InputValidator;
import lotto.validator.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    public static void run() {
        int purchaseAmount = readPurchaseAmount();
        List<Lotto> lottos = LottoFactory.createLottos(LottoCalculator.calculateLottoAmount(purchaseAmount));
        OutputView.printPurchasedLotto(lottos);

        WinnerLotto inputLotto = readWinnerLotto();
        List<Rank> ranks = LottoCalculator.getWinningRanks(lottos, inputLotto, LottoFactory.createRandomWinnerLotto());
        Map<Rank, Integer> statistics = LottoCalculator.getRankStatistics(ranks);

        OutputView.printStatistics(LottoCalculator.calculateProfitRate(purchaseAmount, ranks), statistics);
    }

    private static int readPurchaseAmount() {
        String input = InputView.ReadInput("구입금액");
        LottoValidator.isValidPurchaseAmounts(input);
        return Integer.parseInt(input);
    }

    private static WinnerLotto readWinnerLotto() {
        String input = InputView.ReadInput("당첨 번호");
        List<Integer> winNumbers = InputView.parseNumbers(input);
        input = InputView.ReadInput("보너스 번호");
        int bonus = InputValidator.validateBonusNumber(input, winNumbers);
        return LottoFactory.createWinnerLotto(winNumbers, bonus);
    }
}
