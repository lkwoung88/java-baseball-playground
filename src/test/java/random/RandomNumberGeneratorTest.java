package random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @DisplayName("1 - 9 까지의 중복이 없는 세자리 숫자를 생성한다.")
    @Test
    void generateTargetNumber(){

        // given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        String targetNumber = randomNumberGenerator.getTargetNumber();

        // then
        assertThat(targetNumber).hasSize(3);
        // NOTE 랜덤한 값에 대해서는 어떻게 검증하는게 좋을까?
        assertThat(targetNumber.charAt(0)).isNotEqualTo(targetNumber.charAt(1));
        assertThat(targetNumber.charAt(0)).isNotEqualTo(targetNumber.charAt(2));
        assertThat(targetNumber.charAt(1)).isNotEqualTo(targetNumber.charAt(2));
    }

}
