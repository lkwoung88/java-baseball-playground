package baseballgame.before.baseball;

public enum GameStatus {
    IN_PROGRESS("진행중"),
    WIN("승리"),
    ;

    private final String description;

    GameStatus(String description) {
        this.description = description;
    }
}
