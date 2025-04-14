package random;

import game.ball.Balls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import game.ball.RandomBallGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RandomBallGeneratorTest {

    @DisplayName("1 - 9 까지의 중복이 없는 세자리 숫자를 생성한다.")
    @Test
    void generateTargetNumber(){

        // given
        RandomBallGenerator randomBallGenerator = new RandomBallGenerator();

        // when
        Balls balls = randomBallGenerator.getBalls();

        // then
        assertThat(balls.getTargetBalls()).hasSize(3);
        // NOTE 랜덤한 값에 대해서는 어떻게 검증하는게 좋을까?
    }

}
