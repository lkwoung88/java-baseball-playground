package baseballgame.before;

import java.util.Arrays;

public class RandomNumberGenerator {

    private boolean[] numberCheckList = new boolean[10];
    private int count = 0;
    private StringBuilder targetNumbersBuilder = new StringBuilder();

    public String generateRandomNumbers() {
        targetNumbersBuilder.setLength(0);
        count = 0;
        Arrays.fill(numberCheckList, false);

        while (count < 3) {
            int randomNumber = (int) (Math.random() * 10);
            extractRandomNumbers(randomNumber);
        }

        return targetNumbersBuilder.toString();
    }

    private void extractRandomNumbers(int randomNumber) {
        if (numberCheckList[randomNumber] == false) {
            targetNumbersBuilder.append(randomNumber);
            numberCheckList[randomNumber] = true;
            count++;
        }
    }
}
