package game.score;

import game.status.GameStatus;

public class ScoreMessage {
    private GameStatus status;
    private String message;

    private ScoreMessage(GameStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ScoreMessage of(GameStatus status, String message) {
        return new ScoreMessage(status, message);
    }

    public GameStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
