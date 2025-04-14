package game;

public class Score {
    private int ballCount;
    private int strikeCount;

    private Score(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public static Score of(int ballCount, int strikeCount) {
        return new Score(ballCount, strikeCount);
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void append(Score score) {
        this.ballCount += score.getBallCount();
        this.strikeCount += score.getStrikeCount();
    }
}
