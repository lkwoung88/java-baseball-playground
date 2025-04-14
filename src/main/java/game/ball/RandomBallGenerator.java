package game.ball;

import java.util.ArrayList;
import java.util.Random;

public class RandomBallGenerator {

    private final Random random = new Random();

    public Balls getBalls() {
        Balls balls = Balls.of(new ArrayList<>());
        boolean[] isDuplicate = new boolean[10];
        int position = 0;

        while (hasNotThreeNumber(position)) {
            position = extractBall(isDuplicate, position, balls);
        }

        return balls;
    }

    // TODO 로직 개선 필요
    private int extractBall(boolean[] isDuplicate, int position, Balls balls) {
        int randomNumber = getRandomNumber();
        if (isNotDuplicate(isDuplicate[randomNumber])) {
            isDuplicate[randomNumber] = true;
            Ball ball = Ball.of(randomNumber, position);
            balls.add(ball);
            position++;
        }
        return position;
    }

    private int getRandomNumber() {
        return random.nextInt(9) + 1;
    }

    private boolean isNotDuplicate(boolean isDuplicate) {
        return !isDuplicate;
    }

    private boolean hasNotThreeNumber(int count) {
        return count < 3;
    }
}
