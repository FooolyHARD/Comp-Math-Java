package com.senechka.lab2.console;

import com.senechka.lab2.data.DataWorker;
import com.senechka.lab2.data.SelfWorker;
import com.senechka.lab2.data.UserInputWorker;
import com.senechka.lab2.dto.InputData;
import com.senechka.lab2.equation.Equation;
import com.senechka.lab2.equation.QuadraticEquation;
import com.senechka.lab2.equation.ThirdDegreeEquation;
import com.senechka.lab2.equation.TranscendentalEquation;
import com.senechka.lab2.exception.NoSolutionFoundException;
import com.senechka.lab2.math.EquationSolutionMethod;
import com.senechka.lab2.math.HalfDivisionMethod;
import com.senechka.lab2.math.SecantMethod;
import com.senechka.lab2.math.SimpleIterationMethod;
import com.senechka.lab2.system.FirstSystem;
import com.senechka.lab2.system.SecondSystem;
import com.senechka.lab2.system.SystemTask;

import java.util.List;
import java.util.Scanner;

public class ConsoleWorker {
    private static Scanner in = new Scanner(System.in);


    public static boolean isEquation() {
        String answer;
        do {
            Messages.chooseTaskMessage();

            answer = in.nextLine().trim();

        } while (!(answer.equals("1") || answer.equals("2")));

        return answer.equals("1");
    }

    public static Equation chooseEquation() {

        String answer;
        do {
            Messages.chooseEquationMessage();

            answer = in.nextLine().trim();

        } while (!(answer.equals("1") || answer.equals("2") || answer.equals("3")));

        return switch (answer) {
            case "2" -> new QuadraticEquation();
            case "3" -> new TranscendentalEquation();
            default -> new ThirdDegreeEquation();
        };
    }

    public static SystemTask chooseSystem() {
        String answer;
        do {
            Messages.chooseSystemMessage();

            answer = in.nextLine().trim();

        } while (!(answer.equals("1") || answer.equals("2")));

        return answer.equals("1") ? new FirstSystem() : new SecondSystem();
    }

    public static EquationSolutionMethod chooseMethod() {
        String answer;
        do {
            Messages.chooseEquationMethodMessage();

            answer = in.nextLine().trim();

        } while (!(answer.equals("1") || answer.equals("2") || answer.equals("3")));

        return switch (answer) {
            case "1" -> new HalfDivisionMethod();
            case "2" -> new SecantMethod();
            default -> new SimpleIterationMethod();
        };
    }

    public static DataWorker chooseDataWorker(Equation equation) {

        String answer;
        do {
            Messages.chooseDataWorkerMessage();

            answer = in.nextLine().trim();

        } while (!(answer.equals("1") || answer.equals("2")));

        return answer.equals("1") ? new UserInputWorker() : new SelfWorker(equation);

    }

    public static InputData chooseInterval(List<InputData> intervals) throws NoSolutionFoundException {

        if (intervals.isEmpty()) {
            throw new NoSolutionFoundException();
        }

        if (intervals.size() == 1) {
            Messages.showOnlyIntervalMessage(intervals.get(0));
            return intervals.get(0);
        }

        Integer n = null;
        do {
            Messages.showIntervalsMessage(intervals);
            String line = in.nextLine();
            try {

                n = Integer.parseInt(line);
                if (n > intervals.size() || n < 1) {
                    System.out.println("Наверное вы промахнулись");
                    Messages.tryAgainMessage();
                    n = null;
                }
            } catch (Exception e) {
                System.out.println("Хочу число");
                Messages.tryAgainMessage();
            }
        } while (n == null);

        return intervals.get(n - 1);

    }

    public static Double chooseEpsilon() {
        String answer;
        do {
            Messages.chooseEpsilonMessage();

            answer = in.nextLine().trim();

        } while (!(answer.equals("1") || answer.equals("2")));

        if (answer.equals("2")) {
            return 0.01;
        }

        Double n = null;
        do {
            Messages.chooseYourEpsilonMessage();
            String line = in.nextLine();
            try {

                n = Double.parseDouble(line);
                if (n <= 0 || n > 1) {
                    System.out.println("Повнимательнее с ограничениями");
                    Messages.tryAgainMessage();
                    n = null;
                }
            } catch (Exception e) {
                System.out.println("Хочу число");
                Messages.tryAgainMessage();
            }
        } while (n == null);

        return n;
    }

    public static boolean inputDataWayIsConsole(){
        String answer;
        do {
            Messages.chooseInputWayMessage();
            answer = in.nextLine();

        } while (!(answer.equals("1") || answer.equals("2")));

        return answer.equals("1");
    }

    public static void endWithException(Exception e) {
        System.out.println("Больше так не делайте : " + e.getMessage());
    }
}
