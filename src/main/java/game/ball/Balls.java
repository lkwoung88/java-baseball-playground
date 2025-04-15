package game.ball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private List<Ball> targetBalls = new ArrayList<>();

    private Balls(List<Ball> targetBalls) {
        this.targetBalls = targetBalls;
    }

    public static Balls of(List<Ball> balls) {
        return new Balls(balls);
    }

    public static Balls of(String ballsString) {
        String[] balls = ballsString.split("");
        List<Ball> ballsList = new ArrayList();

        for (int position = 0; position < balls.length; position++) {
            int ballNumber = Integer.parseInt(balls[position]);
            Ball ball = Ball.of(ballNumber, position);
            ballsList.add(ball);
        }

        return new Balls(ballsList);
    }

    public List<Ball> getTargetBalls() {
        return targetBalls;
    }

    public void add(Ball ball) {
        this.targetBalls.add(ball);
    }
}
