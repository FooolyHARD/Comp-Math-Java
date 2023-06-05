package com.senechka.lab2.console;

import com.senechka.lab2.dto.InputData;
import com.senechka.lab2.equation.QuadraticEquation;
import com.senechka.lab2.equation.ThirdDegreeEquation;
import com.senechka.lab2.equation.TranscendentalEquation;
import com.senechka.lab2.system.FirstSystem;
import com.senechka.lab2.system.SecondSystem;

import java.util.List;

public class Messages {
    public static void chooseTaskMessage() {

        System.out.println("Выбери, что будем решать: ");
        System.out.println("\t1. Уравнение");
        System.out.println("\t2. Система");
    }

    public static void chooseInputWayMessage() {

        System.out.println("Откуда взять данные: ");
        System.out.println("\t1. Сам введу");
        System.out.println("\t2. Из файла");
    }

    public static void chooseEquationMessage() {

        System.out.println("Выбери уравнение: ");
        System.out.println("\t1. " + ThirdDegreeEquation.equation);
        System.out.println("\t2. " + QuadraticEquation.equation);
        System.out.println("\t3. " + TranscendentalEquation.equation);
    }

    public static void chooseSystemMessage() {

        System.out.println("Выбери уравнение: ");
        System.out.println("\t1. " + FirstSystem.system);
        System.out.println("\t2. " + SecondSystem.system);
    }

    public static void chooseEquationMethodMessage() {

        System.out.println("Выбери метод, которым будем его решать: ");
        System.out.println("\t1. Метод половинного деления");
        System.out.println("\t2. Метод секущих");
        System.out.println("\t3. Метод простой итерации");
    }

    public static void chooseEpsilonMessage() {
        System.out.println("Хотите свою погрешность (1) или по умолчанию - 0.01 (2)?");
    }

    public static void chooseYourEpsilonMessage() {
        System.out.println("Введите погрешность (Больше 0, меньше 1)?");
    }

    public static void chooseDataWorkerMessage() {

        System.out.println("Надо решить с интервалом, где мне искать корни.");
        System.out.println("Вы сами укажете (1) или мне самому поискать (2)?");
    }

    public static void inputLeftIntervalMessage() {
        System.out.println("Введите левый интервал");
    }

    public static void inputRightIntervalMessage() {
        System.out.println("Введите правый интервал (то что он больше левого это же очев?)");
    }

    public static void tryAgainMessage() {
        System.out.println("Попробуем еще раз");
        System.out.println("---------------------------");
    }

    public static void showIntervalsMessage(List<InputData> intervals) {
        System.out.println("На указанном интервале нашлось несколько корней");
        System.out.println("Давайте выберем какой из них будем определять точно");
        int a = 1;
        for (InputData i : intervals) {
            System.out.println("\t" + a + ": " + i);
            a++;
        }
    }

    public static void showOnlyIntervalMessage(InputData interval) {
        System.out.println("На указанном интервале нашелся один корень: " + interval);
    }

    public static void initialApproximationMessage() {
        System.out.println("Нужно ввести начальное приближение : ");
    }

}
