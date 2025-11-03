package lotto.model;

import java.util.List;

import static lotto.validator.LottoValidator.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
