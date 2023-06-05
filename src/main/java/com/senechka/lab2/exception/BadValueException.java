package com.senechka.lab2.exception;

public class BadValueException extends Exception {
    public BadValueException() {
        super("Не хочу долго считать, давайте от -100 до 100");
    }
}
