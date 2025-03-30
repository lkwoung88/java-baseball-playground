package baseballgame.before.application;

import baseballgame.before.baseball.BaseBallGame;
import baseballgame.before.RandomNumberGenerator;
import baseballgame.before.io.IoHandler;

import static baseballgame.before.application.ApplicationStatus.APPLICATION_IN_PROGRESS;

public class GameApplication {

    public static ApplicationStatus applicationStatus;

    public static void main(String[] args) {
        IoHandler ioHandler = new IoHandler();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        do {
            String targetNumbers = randomNumberGenerator.generateRandomNumbers();
            BaseBallGame baseBallGame = new BaseBallGame(ioHandler, targetNumbers);
            applicationStatus = baseBallGame.run();
        } while (isProgress());
    }

    private static boolean isProgress() {
        return applicationStatus == APPLICATION_IN_PROGRESS;
    }
}
