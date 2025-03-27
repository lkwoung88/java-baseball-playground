package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @DisplayName("1,2를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    @Test
    void split(){
        // given
        String str = "1,2";

        // when
        String[] split = str.split(",");

        // then
        assertThat(split).hasSize(2)
                .containsExactly("1", "2");
    }
    
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    @Test
    void split2(){
        // given
        String str = "1";
    
        // when
        String[] split = str.split(",");

        // then
        assertThat(split).hasSize(1)
                .contains("1");
    }

    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2을 반환하도록 구현한다.")
    @Test
    void subString(){
        // given
        String str = "(1,2)";

        // when
        String substring = str.substring(1, 4);

        // then
        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("charAt 메서드는 특정 인덱스의 문자를 반환한다.")
    @Test
    void charAt(){
        // given
        String str = "abc";

        // when
        char character = str.charAt(0);

        // then
        assertThat(character).isEqualTo('a');
    }

    @DisplayName("charAt 메서드는 주어진 문자열의 인덱스를 벗어나면 예외를 발생시킨다.")
    @Test
    void charAtExceptionCase(){
        // given
        String str = "abc";

        // when & then
        assertThatThrownBy(()-> str.charAt(5)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
