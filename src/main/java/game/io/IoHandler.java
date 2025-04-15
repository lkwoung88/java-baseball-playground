package game.io;

import java.util.Scanner;

public class IoHandler {
    private static Scanner scanner = new Scanner(System.in);

    public String getInputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String inputNumbers;

        do {
            inputNumbers = scanner.next();
        } while (this.isValidInputNumbers(inputNumbers) == false);

        return inputNumbers;
    }

    public void winningComments() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public String retryComments() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input;
        do {
            input = scanner.next();
        } while (this.isValidGameInput(input) == false);

        return input;
    }

    public void inputResultComments(String message) {
        System.out.println(message);
    }

    private boolean isValidInputNumbers(String inputNumbers) {
        if (isNumberString(inputNumbers) == false || inputNumbers.length() != 3) {
            System.out.println("올바르지 않은 입력입니다. 다시 입력해주세요");
            return false;
        }

        return true;
    }

    private boolean isNumberString(String inputNumbers) {
        try {
            Integer.valueOf(inputNumbers);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isValidGameInput(String input) {
        if ("1".equals(input) || "2".equals(input)) {
            return true;
        }

        return false;
    }
}
