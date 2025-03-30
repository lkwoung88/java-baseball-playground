package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MathTest {

    @DisplayName("")
    @Test
    void random(){
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        double random = Math.random();

        // when
        int targetNumber = (int) (random * 10);

        // then
        assertThat(numbers).contains(targetNumber);
    }
}
