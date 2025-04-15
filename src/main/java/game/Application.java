package game;

import game.ball.Balls;
import game.ball.RandomBallGenerator;
import game.io.IoHandler;

public class Application {

    private static RandomBallGenerator randomBallGenerator = new RandomBallGenerator();
    private static IoHandler ioHandler = new IoHandler();

    public static void main(String[] args) {
        ApplicationStatus status;

        do {
            Balls targetBalls = randomBallGenerator.getBalls();
            BaseBallGame baseBallGame = new BaseBallGame(targetBalls, ioHandler);
            baseBallGame.run();
            status = askPlayContinue();
        } while (ApplicationStatus.isInProgress(status));
    }

    private static ApplicationStatus askPlayContinue() {
        String retryInput = ioHandler.retryComments();

        if ("2".equals(retryInput)) {
            return ApplicationStatus.TERMINATED;
        }

        return ApplicationStatus.IN_PROGRESS;
    }
}
