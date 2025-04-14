package game;

import game.ball.Ball;
import game.ball.BallStatus;
import game.ball.Balls;

import java.util.List;

import static game.GameStatus.IN_PROCESS;
import static game.GameStatus.WIN;
import static game.ball.BallStatus.*;

public class Umpire {

    private Balls targetBalls;

    public Umpire(Balls targetBalls) {
        this.targetBalls = targetBalls;
    }

    public ScoreMessage makeScoreOutBy(Balls guessBalls) {
        List<Ball> guessBallList = guessBalls.getTargetBalls();

        Score resultScore = Score.of(0, 0);

        for (Ball guessBall : guessBallList) {
            Score score = this.judge(guessBall);
            resultScore.append(score);
        }

        int strikeCount = resultScore.getStrikeCount();
        int ballCount = resultScore.getBallCount();

        if (isThreeStrike(strikeCount)) {
            return ScoreMessage.of(WIN, "3스트라이크");
        }

        StringBuilder message = new StringBuilder();
        if (hasCount(strikeCount)) {
            String comment = String.format("%d 스트라이크", strikeCount);
            message.append(comment);
        }
        if (hasCount(ballCount)) {
            String comment = String.format("%d 볼", ballCount);
            message.append(comment);
        }

        return ScoreMessage.of(IN_PROCESS, message.toString());
    }

    public Score judge(Ball guessBall) {
        List<Ball> targetBallList = this.targetBalls.getTargetBalls();

        int strikeCount = (int)targetBallList.stream()
                .filter(targetBall -> this.judge(targetBall, guessBall) == STRIKE)
                .count();
        int ballCount = (int) targetBallList.stream()
                .filter(targetBall -> this.judge(targetBall, guessBall) == BALL)
                .count();

        return Score.of(ballCount, strikeCount);
    }

    public BallStatus judge(Ball targetBall, Ball guessBall) {
        if (isStrike(targetBall, guessBall)) {
            return STRIKE;
        }

        if (isBall(targetBall, guessBall)) {
            return BALL;
        }

        return MISS;
    }

    private boolean isThreeStrike(int strikeCount) {
        return strikeCount == 3;
    }

    private boolean hasCount(int strikeCount) {
        return strikeCount != 0;
    }

    private boolean isStrike(Ball targetBall, Ball guessBall) {
        return targetBall.equals(guessBall);
    }

    private boolean isBall(Ball targetBall, Ball guessBall) {
        return targetBall.getNumber() == guessBall.getNumber();
    }
}
