package study.baseball;


import java.util.Objects;

public class Ball {

    public int number;
    public int position;

    public Ball(int number, int position) {
        this.number = number;
        this.position = position;
    }


    public int getNumber() {
        return number;
    }

    public int getPosition() {
        return position;
    }

    public BallStatus play(Ball userBall) {
        if (this.equals(userBall)) {
            return BallStatus.STRIKE;
        }
        if (userBall.matBallNo(number)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTING;
    }

    private boolean matBallNo(int number) {
        return this.number == number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number && position == ball.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
