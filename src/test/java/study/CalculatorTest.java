package study;

import calculator.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.")
    void CalculatorTest() {
        // given
        Calculator calculator = new Calculator();
        // when
        int execute = calculator.execute();

        // then
        assertThat(execute).isEqualTo(10);
    }
}
