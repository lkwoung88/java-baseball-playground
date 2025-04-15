package game.status;

public enum GameStatus {
    WIN, IN_GAME;

    public static boolean isInGame(GameStatus gameStatus) {
        return IN_GAME.equals(gameStatus);
    }

    public static boolean isWin(GameStatus status) {
        return WIN.equals(status);
    }
}
