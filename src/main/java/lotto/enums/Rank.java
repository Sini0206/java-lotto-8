package lotto.enums;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false);

    private final int matchCount;
    private final int prize;
    private final boolean isBonusRequired;

    Rank(int machCount, int prize, boolean isBonusRequired) {
        this.matchCount = machCount;
        this.prize = prize;
        this.isBonusRequired = isBonusRequired;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isBonusRequired() {
        return isBonusRequired;
    }

    public static Rank calculateRank(int matchCount, boolean isBonusMatched) {
        return Arrays
                .stream(Rank.values())
                .filter(rank -> (rank.matchCount == matchCount) && (rank.isBonusRequired == isBonusMatched))
                .findFirst()    // (matchCount, isBonusMatched) 조합으로는 정확히 하나의 Rank만 매칭
                .orElseThrow(() -> new IllegalArgumentException(
                        ErrorMessage.RANK_NOT_EXIST.getMessage()
                        ));
    }
}
