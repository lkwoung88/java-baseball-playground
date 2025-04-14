package ball;

import game.Ball;
import game.Umpire;
import game.status.BallStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static game.status.BallStatus.*;
import static game.status.BallStatus.MISS;
import static org.assertj.core.api.Assertions.assertThat;


class BallTest {

    private static Umpire umpire;


    @BeforeAll
    static void setup() {
        umpire = new Umpire();
    }

    @DisplayName("같은 수, 같은 자리수이면 '스트라이크' 처리한다.")
    @Test
    void isStrike() {
        // given
        Ball targetBall = Ball.of(1, 2);
        Ball guessBall = Ball.of(1, 2);

        // when
        BallStatus resultStatus = umpire.judge(targetBall, guessBall);

        // then
        assertThat(resultStatus).isEqualTo(STRIKE);
    }

    @DisplayName("같은 수, 다른 자리수이면 '볼' 처리한다.")
    @Test
    void isBall() {
        // given
        Ball targetBall = Ball.of(1, 2);
        Ball guessBall = Ball.of(1, 3);

        // when
        BallStatus resultStatus = umpire.judge(targetBall, guessBall);

        // then
        assertThat(resultStatus).isEqualTo(BALL);
    }

    @DisplayName("같은 수가 아니면 '미스' 처리한다.")
    @Test
    void isMiss() {
        // given
        Ball targetBall = Ball.of(1, 2);
        Ball guessBall = Ball.of(2, 3);

        // when
        BallStatus resultStatus = umpire.judge(targetBall, guessBall);

        // then
        assertThat(resultStatus).isEqualTo(MISS);
    }
}
