package utils;

import java.util.Random;

public class RandomNumberGenerator {

    private final Random random = new Random();

    public String getTargetNumber() {
        boolean[] isDuplicate = new boolean[10];
        StringBuilder targetNumber = new StringBuilder();

        while (hasNotThreeNumber(targetNumber)) {
            extractRandomNumber(isDuplicate, targetNumber);
        }

        return targetNumber.toString();
    }

    private void extractRandomNumber(boolean[] isDuplicate, StringBuilder targetNumber) {
        int randomNumber = getRandomNumber();
        if (isNotDuplicate(isDuplicate[randomNumber])) {
            isDuplicate[randomNumber] = true;
            targetNumber.append(randomNumber);
        }
    }

    private int getRandomNumber() {
        return random.nextInt(9) + 1;
    }

    private boolean isNotDuplicate(boolean isDuplicate) {
        return !isDuplicate;
    }

    private boolean hasNotThreeNumber(StringBuilder targetNumber) {
        return targetNumber.length() < 3;
    }
}
