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

    public static Score getScoreFrom(String targetNumbers, String inputNumbers) {
        Score score = Score.of();

        for (int idx = 0; idx < inputNumbers.length(); idx++) {
            char inputNumber = inputNumbers.charAt(idx);
            boolean isBall = targetNumbers.contains(String.valueOf(inputNumber));
            boolean isStrike = targetNumbers.charAt(idx) == inputNumber;

            score.calculateScore(isStrike, isBall);
        }

        return score;
    }

    public void calculateScore(boolean isStrike, boolean isBall) {
        if (isStrike) {
            this.increaseStrike();
        }
        else if (isBall) {
            this.increaseBall();
        }
    }

    private void increaseStrike() {
        strikeCount++;
    }

    private void increaseBall() {
        ballCount++;
    }

    public void clearScore() {
        strikeCount = 0;
        ballCount = 0;
    }

    public boolean isStrikeout() {
        return this.strikeCount == 3;
    }

    public boolean isNotStrikeout() {
        return !this.isStrikeout();
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
