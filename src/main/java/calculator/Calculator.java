package calculator;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Calculator {

    public int execute() {

        int result = 0;
        String input = "2 + 3 * 4 / 2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split(" ");


        for (int i = 0; i < values.length; i++) {

            if (i % 2 != 0) {
                result = calculate(result, Integer.parseInt(values[i + 1]), values[i]);
            }

            if (i == 0) {
                result = Integer.parseInt(values[i]);
            }

        }
        return result;
    }

    public int calculate(int now, int next, String operator) {

        switch (operator) {
            case "+":
                return now + next;
            case "-":
                return now - next;
            case "*":
                return now * next;
            case "/":
                return now / next;
        }
        return now;
    }

}
