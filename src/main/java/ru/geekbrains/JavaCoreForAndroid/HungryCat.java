package ru.geekbrains.JavaCoreForAndroid;

/**
 * Сourse: java core for android
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 *
 * HomeWork for lesson 6
 * Created 09.02.2021
 * v1.0
 */
public class HungryCat {
    protected String name;                // Имя едока
    protected int appetite;               // Аппетит или вместимость кота в единицах еды
    protected int currentFilling;         // Текущее состояние голода кота пусть будет в абсолютных единицах еды

    public HungryCat(String name, int appetite, int currentFilling) {
        this.name = name;
        this.appetite = appetite;
        this.currentFilling = currentFilling;
    }

    // метод ненавязчивого предложения коту покушать
    // реализуемая логика:
    // если кот не голоден (т.е. его сытость больше 90%) он откажется.
    // если если он голоден но в миске недостаточно еды для утоления его голода - он откажется из гордости...
    // в остальных случаях он налупится до отвала.
    public boolean offerToEat(Dish dish) {
        if (100 - ((double) (appetite - currentFilling) / appetite) * 100 <= 90 && dish.getCurrentFilling() >= appetite - currentFilling) {
            // принято решение выполнять процесс уменьшения еды в миске и насыщения кота единой командой, во избежании ошибок.
            // причем с той стороны тоже есть проверка, и в случае "проблем" в "миске", миска просто не передаст еду
            // и кот ей не насытится.
            this.currentFilling += dish.decreaseFoodInDish(this.appetite - this.currentFilling);
            return true;
        }
        // котик отказывается кушать
        return false;
    }

    public boolean isHungry() {
        return 100 - ((double) (appetite - currentFilling) / appetite) * 100 <= 90;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public int getCurrentFilling() {
        return currentFilling;
    }
}
