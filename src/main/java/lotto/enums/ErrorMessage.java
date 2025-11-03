package lotto.enums;

import static lotto.validator.LottoValidator.*;

public enum ErrorMessage {
    EMPTY_INPUT("빈 칸은 입력 불가합니다."),
    NOT_NUMBER("숫자 형식이어야 합니다."),
    NOT_DIVIDED_BY_LOTTO_PRICE("단위가 아닙니다."),
    NOT_MINIMUM_PURCHASE_AMOUNTS("최소 구매 가격은 " + LOTTO_PRICE + "원 입니다."),
    WRONG_LOTTO_NUMBER_RANGE("로또 번호는 " + LOTTO_MIN_NUMBER + "~ " + LOTTO_MAX_NUMBER + "이내의 숫자여야 합니다."),
    WRONG_LOTTO_NUMBER_SIZE("로또 번호는 " + LOTTO_SIZE + "개여야 합니다."),
    CAN_NOT_MATCH_BONUS_NUMBER("보너스 번호는 당첨 번호들과 불일치해야 합니다."),
    LOTTO_NOT_EXIST("로또가 존재하지 않습니다."),
    RANK_NOT_EXIST("존재하지 않는 등수입니다.");

    private final String prefix = "[ERROR]";
    private String message;

    ErrorMessage(String message) {
        this.message = prefix + message;
    }

    public String getMessage() {
        return message;
    }
}
