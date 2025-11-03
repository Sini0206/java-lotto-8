package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.validator.InputValidator.canParseToNumber;
import static lotto.validator.InputValidator.validateInput;

public class InputView {
    public static void guideInput(String need) {
        System.out.println(need + "을 입력해 주세요.");
    }

    public static String ReadInput(String guide) {
        guideInput(guide);
        String input = Console.readLine();
        validateInput(input);

        return input;
    }

    public static List<Integer> parseNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (String s : input.split(",")) {
            int num = canParseToNumber(s);
            numbers.add(num);
        }
        return numbers;
    }
}
