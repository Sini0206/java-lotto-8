package lotto.view;

import camp.nextstep.edu.missionutils.Console;

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
}
