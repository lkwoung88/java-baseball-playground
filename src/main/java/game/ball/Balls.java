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

    public List<Ball> getTargetBalls() {
        return targetBalls;
    }
}
