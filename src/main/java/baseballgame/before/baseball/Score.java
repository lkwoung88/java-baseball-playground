package baseballgame.before.baseball;

public class Score {
    private int strikeCount;
    private int ballCount;

    private Score(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static Score of() {
        return new Score(0, 0);
    }

    public void calculateScore(boolean isStrike, boolean isBall) {
        if (isStrike) {
            this.increaseStrike();
        }
        else if (isBall) {
            this.increaseBall();
        }
    }

    public void increaseStrike() {
        strikeCount++;
    }

    public void increaseBall() {
        ballCount++;
    }

    public void clearScore() {
        strikeCount = 0;
        ballCount = 0;
    }

    public boolean isStrikeout() {
        return this.strikeCount == 3;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isNotStrikeout() {
        return !this.isStrikeout();
    }
}
