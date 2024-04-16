package study.baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Balls {

    private static final Integer MIN = 1;
    private static final Integer MAX = 9;
    private static final Integer MAX_SIZE = 3;

    public List<Ball> balls;

    public Balls(List<Integer> answer) {
        this.balls = mapBall(answer);
    }

    private List<Ball> mapBall(List<Integer> answer) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answer.get(i)));
        }
        return balls;
    }

    public boolean isNotSame() {
        List<Integer> collect = balls.stream().map(Ball::getNumber).distinct().collect(Collectors.toList());
        return collect.size() == MAX_SIZE;
    }

    public boolean ballMinMaxSize() {
        return balls.stream().map(Ball::getNumber).allMatch(ball -> MIN <= ball && MAX >= ball);
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public BallStatus play(Ball userBall) {
        return balls.stream()
                .map(answer -> answer.play(userBall))
                .filter(status -> status != BallStatus.NOTING)
                .findFirst()
                .orElse(BallStatus.NOTING);

    }

}
