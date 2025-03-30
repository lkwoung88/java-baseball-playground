package baseballgame.before.baseball;

import baseballgame.before.application.ApplicationStatus;
import baseballgame.before.io.IoHandler;

import static baseballgame.before.application.ApplicationStatus.*;
import static baseballgame.before.baseball.GameStatus.*;

public class BaseBallGame {

    private GameStatus gameStatus;
    private final String targetNumbers;
    private final IoHandler ioHandler;

    public BaseBallGame(IoHandler ioHandler, String targetNumbers) {
        this.ioHandler = ioHandler;
        this.targetNumbers = targetNumbers;
    }

    public ApplicationStatus run() {
        this.gameStatus = IN_PROGRESS;
        ApplicationStatus applicationStatus = APPLICATION_IN_PROGRESS;

        while (isProgress()) {
            String inputNumbers = this.ioHandler.getInputNumber();
            Score score = this.calculateScore(inputNumbers);
            applicationStatus = checkResultBy(score);
        }

        return applicationStatus;
    }

    private ApplicationStatus checkResultBy(Score score) {
        if (score.isNotStrikeout()) {
            this.ioHandler.inputResultComments(score.getBallCount(), score.getStrikeCount());
            return APPLICATION_IN_PROGRESS;
        }

        this.gameStatus = WIN;
        String retryInput = ioHandler.winningComments();

        if (isTerminateRequest(retryInput)) {
            return APPLICATION_TERMINATE;
        }

        return APPLICATION_IN_PROGRESS;
    }

    private Score calculateScore(String inputNumbers) {
        Score score = Score.of();

        for (int idx = 0; idx < inputNumbers.length(); idx++) {
            char inputNumber = inputNumbers.charAt(idx);
            boolean isBall = this.targetNumbers.contains(String.valueOf(inputNumber));
            boolean isStrike = this.targetNumbers.charAt(idx) == inputNumber;

            score.calculateScore(isStrike, isBall);
        }

        return score;
    }

    private boolean isProgress() {
        return this.gameStatus == IN_PROGRESS;
    }

    private boolean isTerminateRequest(String retryInput) {
        return "2".equals(retryInput);
    }
}
