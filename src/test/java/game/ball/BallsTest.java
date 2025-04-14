package game.ball;

import game.status.GameStatus;
import game.score.ScoreMessage;
import game.score.Umpire;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {
    
    @DisplayName("3개의 숫자가 모두 맞으면 한 라운드가 끝난다.")
    @Test
    void makeResultOut_Correct(){
    
        // given
        List<Ball> targetBallList = List.of(
                Ball.of(1, 1),
                Ball.of(2, 2),
                Ball.of(3, 3)
        );
        Balls targetBalls = Balls.of(targetBallList);

        Umpire umpire = new Umpire(targetBalls);

        // when
        List<Ball> guessBallList = List.of(
                Ball.of(1, 1),
                Ball.of(2, 2),
                Ball.of(3, 3)
        );
        Balls guessBalls = Balls.of(guessBallList);
        ScoreMessage message = umpire.makeScoreOutBy(guessBalls);
    
        // then
        assertThat(message.getStatus()).isEqualTo(GameStatus.WIN);
        assertThat(message.getMessage()).isEqualTo("3스트라이크");
    }
}
