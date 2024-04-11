package baseball;

import java.util.*;

public class BaseBall {

    public int makeRandomNumber() {
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        while (set.size() < 3) {
            int randomNumber = random.nextInt(10);
            set.add(randomNumber);
        }
        StringBuilder result = new StringBuilder();
        for (Integer num : set) {
            result.append(num);
        }

        int randomNumber = Integer.parseInt(result.toString());

        System.out.println("randomNumber = " + randomNumber);
        return randomNumber;
    }

    public void execute() {
        int randomNumber = makeRandomNumber();
        boolean isPlaying = true;

        while (isPlaying) {
            int strike = 0;
            int ball = 0;
            int noting = 0;

            Scanner scanner = new Scanner(System.in);
            System.out.print("숫자를 입력해주세요 : ");

            String[] randoms = String.valueOf(randomNumber).split("");
            String[] requests = scanner.nextLine().split("");

            for (int i = 0; i < randoms.length; i++) {
                strike = increaseStrikeCount(requests, i, randoms, strike);
                ball = increaseBallCount(requests, i, randoms, randomNumber, ball);
                noting = increaseNotingCount(requests, i, randoms, randomNumber, noting);
            }

            if (checkTheCount(noting, strike, ball)) continue;

            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            Scanner nextScanner = new Scanner(System.in);
            String reGame = nextScanner.nextLine();

            isReGame(reGame);

            isPlaying = false;
        }

    }

    public int increaseNotingCount(String[] requests, int i, String[] randoms, int randomNumber, int noting) {
        if (!requests[i].equals(randoms[i]) && !String.valueOf(randomNumber).contains(requests[i])) {
            noting++;
        }
        return noting;
    }

    public int increaseBallCount(String[] requests, int i, String[] randoms, int randomNumber, int ball) {
        if (!requests[i].equals(randoms[i]) && String.valueOf(randomNumber).contains(requests[i])) {
            ball++;
        }
        return ball;
    }

    public int increaseStrikeCount(String[] requests, int i, String[] randoms, int strike) {
        if (requests[i].equals(randoms[i])) {
            strike++;
        }
        return strike;
    }

    public void isReGame(String reGame) {
        if (Objects.equals(reGame, "1")) {
            this.execute();
        }
    }

    public boolean checkTheCount(int noting, int strike, int ball) {
        if (noting == 3) {
           System.out.println("Hint : 낫싱");
            return true;
        }
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            return true;
        }
        if (strike != 0 && strike != 3) {
            System.out.println(strike + "스트라이크");
            return true;
        }
        if (ball != 0) {
            System.out.println(ball + "볼");
            return true;
        }
        return false;
    }


}
