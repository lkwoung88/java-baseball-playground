package game;

import game.status.BallStatus;

import static game.status.BallStatus.*;

public class Umpire {

    public BallStatus judge(Ball targetBall, Ball guessBall) {
        if (isStrike(targetBall, guessBall)) {
            return STRIKE;
        }

        if (isBall(targetBall, guessBall)) {
            return BALL;
        }

        return MISS;
    }

    private boolean isStrike(Ball targetBall, Ball guessBall) {
        return targetBall.equals(guessBall);
    }

    private boolean isBall(Ball targetBall, Ball guessBall) {
        return targetBall.getNumber() == guessBall.getNumber();
    }
}
