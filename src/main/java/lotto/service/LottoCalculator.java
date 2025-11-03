package lotto.service;

import lotto.enums.Rank;
import lotto.model.Lotto;
import lotto.dto.WinnerLotto;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.validator.LottoValidator.LOTTO_PRICE;

public class LottoCalculator {
    public static int calculateLottoAmount(int purchaseAmounts) {
        return purchaseAmounts / LOTTO_PRICE;
    }

    public static List<Rank> getWinningRanks(List<Lotto> purchasedLotto, WinnerLotto inputLotto, WinnerLotto winnerLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : purchasedLotto) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winnerLotto.lottoNumbers()::contains)
                    .count();
            boolean isBonusMatched = lotto.getNumbers().contains(winnerLotto.bonusNumber());

            try {
                Rank rank = Rank.calculateRank(matchCount, isBonusMatched);
                ranks.add(rank);
            } catch (IllegalArgumentException e) {
                // 의도적으로 무시: 해당 로또는 당첨 등수 없음
            }
        }
        return ranks;
    }

    public static Map<Rank,Integer> getRankStatistics(List<Rank> ranks) {
        Map<Rank, Integer> statistics = Arrays.stream(Rank.values())
                .collect(Collectors.toMap(rank -> rank, rank -> 0));

        ranks.forEach(rank -> statistics.merge(rank, 1, Integer::sum));

        return statistics;
    }

    private static int calculateTotalPrize(List<Rank> ranks) {
        if (ranks.isEmpty()) {
            return 0;
        }

        int totalPrize = 0;

        for (Rank rank : ranks) {
            totalPrize += rank.getPrize();
        }

        return totalPrize;
    }

    public static double calculateProfitRate(int purchaseAmount, List<Rank> ranks) {
        int totalPrize = calculateTotalPrize(ranks);
        return  (double) purchaseAmount / totalPrize * 100;
    }
}
