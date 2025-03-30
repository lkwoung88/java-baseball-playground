package baseballgame.before;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @DisplayName("서로 다른 세자수 랜덤값을 구한다.")
    @Test
    void generateRandomNumbers() {
        // given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        String randomNumbers = randomNumberGenerator.generateRandomNumbers();
        String[] split = randomNumbers.split("");

        // then
        assertThat(split).hasSize(3);
        assertThat(split[0]).isNotEqualTo(split[1]);
        assertThat(split[0]).isNotEqualTo(split[2]);
        assertThat(split[1]).isNotEqualTo(split[2]);
    }
}