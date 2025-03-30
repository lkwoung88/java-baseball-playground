package baseballgame.before.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {

    @DisplayName("입력값과 타겟값에 따라 스트라이크와 볼 수 계산 테스트")
    @ParameterizedTest
    @CsvSource({
            "123,123,3,0",
            "123,132,1,2",
            "123,456,0,0",
            "123,124,2,0",
            "123,312,0,3"
    })
    void getScoreFromInputNumbers(String inputNumbers, String targetNumbers, int expectedStrikes, int expectedBalls){
        // when
        Score score = Score.getScoreFrom(targetNumbers, inputNumbers);

        // then
        assertThat(score.getStrikeCount()).isEqualTo(expectedStrikes);
        assertThat(score.getBallCount()).isEqualTo(expectedBalls);;
    }

}