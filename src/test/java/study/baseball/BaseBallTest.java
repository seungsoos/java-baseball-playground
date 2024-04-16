package study.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallTest {

    @Test
    @DisplayName("볼은 총 3개이다.")
    void ballSize() {
        // given
        Balls balls = new Balls(getList());
        // when

        // then
        assertThat(balls.getBalls().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("볼은 1~9까지의 숫자로 이루어져있다.")
    void ballMinMaxSize() {
        // given
        Balls balls = new Balls(getList());
        // when

        // then
        assertThat(balls.ballMinMaxSize()).isTrue();
    }

    @Test
    @DisplayName("볼은 3개 모두 다른 숫자여야 한다.")
    void ballIsNotSame() {
        // given
        Balls balls = new Balls(getList());
        // when

        // then
        assertThat(balls.isNotSame()).isTrue();
    }

    @Test
    @DisplayName("같은 수가 같은 자리에 있으면 스트라이크")
    void is_strike() {
        // given
        Balls balls = new Balls(getList());

        // when
        BallStatus ballStatus = balls.play(new Ball(1, 1));
        // then
        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }
    @Test
    @DisplayName("같은 수가 다른 자리에 있으면 볼")
    void is_ball() {
        // given
        Balls balls = new Balls(getList());

        // when
        BallStatus ballStatus = balls.play(new Ball(1, 2));
        // then
        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }
    @Test
    @DisplayName("같은 수가 없다면 나싱")
    void is_noting() {
        // given
        Balls balls = new Balls(getList());
        // when
        BallStatus ballStatus = balls.play(new Ball(5, 2));
        // then
        assertThat(ballStatus).isEqualTo(BallStatus.NOTING);
    }
    private List<Integer> getList() {
        return Arrays.asList(1, 2, 3);
    }



}
