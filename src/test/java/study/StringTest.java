package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    void 요구사항_1_1() {
        // given
        String[] strings = "1,2".split(",");


        // when

        // then
        assertThat(strings).containsExactly("1", "2");

    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    void 요구사항_1_2() {
        // given
        String[] strings = "1".split(",");
        // when

        // then
        assertThat(strings).containsExactly("1");
    }


    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    void 요구사항_2() {
        // given
        String str = "(1,2)";
        // when
        String substring = str.substring(1, 4);

        // then
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    void 요구사항_3_1() {
        // given
        String str = "abc";
        // when
        List<Character> list = getCharacters(str);

        // then
        assertThat(list).containsExactly('a', 'b', 'c');
    }

    private List<Character> getCharacters(String str) {
        char c1 = str.charAt(0);
        char c2 = str.charAt(1);
        char c3 = str.charAt(2);
        List<Character> list = Arrays.asList(c1, c2, c3);
        return list;
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    void 요구사항_3_2() {
        // given
        String str = "abc";
        // when

        // then
        assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

}
