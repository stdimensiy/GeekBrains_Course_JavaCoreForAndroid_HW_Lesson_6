package ru.geekbrains.JavaCoreForAndroid;

/**
 * Сourse: java core for android
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 *
 * HomeWork for lesson 6
 * Created 10.02.2021
 * v1.0
 */
public class DishCustomException extends RuntimeException {
    public DishCustomException(String message) {
        super(message);
    }
}
