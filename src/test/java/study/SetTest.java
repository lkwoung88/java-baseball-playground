package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
    @DisplayName("size()로 set의 크기를 확인한다.")
    @Test
    void setSize(){
        // then
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int param){
        // then
        assertThat(numbers.contains(param)).isTrue();
    }

    @DisplayName("contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인한다. 그리고 4, 5는 값이 존재하지 않는 것을 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains2(int param, boolean expect){
        // then
        boolean isContain = numbers.contains(param);
        assertThat(isContain).isEqualTo(expect);
    }

}
