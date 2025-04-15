package game;

import game.ball.Balls;
import game.io.IoHandler;
import game.score.ScoreMessage;
import game.score.Umpire;
import game.status.GameStatus;

import static game.status.GameStatus.IN_GAME;


public class BaseBallGame {

    private final Balls targetBalls;
    private final IoHandler ioHandler;

    public BaseBallGame(Balls targetBalls, IoHandler ioHandler) {
        this.targetBalls = targetBalls;
        this.ioHandler = ioHandler;
    }

    public void run() {
        Umpire umpire = new Umpire(targetBalls);
        GameStatus gameStatus = IN_GAME;

        while (GameStatus.isInGame(gameStatus)) {
            String inputNumbers = this.ioHandler.getInputNumber();
            Balls guessBalls = Balls.of(inputNumbers);
            ScoreMessage scoreMessage = umpire.makeScoreOutBy(guessBalls);
            gameStatus = checkResultBy(scoreMessage);
        }
    }

    private GameStatus checkResultBy(ScoreMessage scoreMessage) {
        GameStatus status = scoreMessage.getStatus();

        ioHandler.inputResultComments(scoreMessage.getMessage());

        if (GameStatus.isWin(status)) {
            ioHandler.winningComments();
        }

        return status;
    }
}
