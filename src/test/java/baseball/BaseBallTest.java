package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallTest {

    @Test
    @DisplayName("랜덤으로 생성된 숫자가 3자리 숫자여야한다.")
    void randomNumber_length() {
        // given
        BaseBall baseBall = new BaseBall();
        int randomNumber = baseBall.makeRandomNumber();
        // when

        // then
        assertThat(randomNumber).isBetween(100, 999);
    }

    @Test
    @DisplayName("랜덤으로 생성된 숫자는 중복이 없어야 한다.")
    void randomNumber_only_unique() {
        // given
        BaseBall baseBall = new BaseBall();
        int randomNumber = baseBall.makeRandomNumber();
        // when
        boolean result = isUnique(String.valueOf(randomNumber));
        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("숫자와 자리가 같을시 strike를 1증가 시킨다.")
    void increaseStrikeCount() {
        // given
        BaseBall baseBall = new BaseBall();

        int randomNumber = 123;
        int requestNumber = 345;
        String[] randomSplit = String.valueOf(randomNumber).split("");
        String[] requestSplit = String.valueOf(requestNumber).split("");

        int strike = 0;

        // when
        int result = baseBall.increaseStrikeCount(randomSplit, 0, requestSplit, strike);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자는 같고, 자리가 다를경우 ball을 1증가 시킨다.")
    void increaseBallCount() {
        // given
        BaseBall baseBall = new BaseBall();

        int randomNumber = 123;
        int requestNumber = 345;
        String[] randomSplit = String.valueOf(randomNumber).split("");
        String[] requestSplit = String.valueOf(requestNumber).split("");

        int ball = 0;

        // when
        int result = baseBall.increaseBallCount(requestSplit, 0, randomSplit, randomNumber, ball);
        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자와 자리가 모두 일치하지않을 경우 낫싱을 1증가 시킨다.")
    void increaseNotingCount() {
        // given
        BaseBall baseBall = new BaseBall();

        int randomNumber = 123;
        int requestNumber = 645;
        String[] randomSplit = String.valueOf(randomNumber).split("");
        String[] requestSplit = String.valueOf(requestNumber).split("");

        int noting = 0;

        // when
        int result = baseBall.increaseNotingCount(requestSplit, 0, randomSplit, randomNumber, noting);
        // then
        assertThat(result).isEqualTo(1);
    }

    private boolean isUnique(String randomNumber) {
        Set<Character> set = new HashSet<>();
        for (char number : randomNumber.toCharArray()) {
            if (!set.add(number)) {
                // 중복된 숫자가 있으면 false 반환
                return false;
            }
        }
        // 중복된 숫자가 없으면 true 반환
        return true;
    }
}