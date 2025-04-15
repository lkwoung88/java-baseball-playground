package game.ball;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class RandomBallGenerator {

    private final Random random = new Random();

    public Balls getBalls() {
        boolean[] isDuplicate = new boolean[10];
        int position = 0;

        List<Ball> ballList = new ArrayList<>();
        while (hasNotThreeNumber(position)) {
            Optional<Ball> optionalBall = extractBall(isDuplicate, position);
            optionalBall.ifPresent(ball -> {
                ballList.add(ball);
            });
            position = ballList.size();
        }

        return Balls.of(ballList);
    }

    // TODO 로직 개선 필요
    private Optional<Ball> extractBall(boolean[] isDuplicate, int position) {
        int randomNumber = getRandomNumber();
        if (isNotDuplicate(isDuplicate[randomNumber])) {
            isDuplicate[randomNumber] = true;
            return Optional.of(Ball.of(randomNumber, position));
        }

        return Optional.empty();
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
