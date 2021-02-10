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
public class Lesson6 {
    static HungryCat[] hc;
    static Dish dish;
    static boolean deprivedcat;
    static char charVal_f = '\u2714'; // код символа галочки согласно таблицы символов юникод
    static char charVal_s = '\u263A'; // код символа смайлика
    static char charVal_a = '\u2639'; // код символа смайлика грустного
    static char charVal_n = '\u266B'; // код символа нотки

    public static void main(String[] args) {
        hc = new HungryCat[9];
        hc[0] = new HungryCat("Мурзик", 100, 50);
        hc[1] = new HungryCat("Алиса", 70, 40);
        hc[2] = new HungryCat("Старый дворовый кот", 200, 20);
        hc[3] = new HungryCat("Алисин сын 1", 50, 10);
        hc[4] = new HungryCat("Алисин сын 2", 50, 10);
        hc[5] = new HungryCat("Соседская кошка Мурка", 80, 60);
        hc[6] = new HungryCat("Одноглазый", 120, 10);
        hc[7] = new HungryCat("Рыжий", 130, 100);
        hc[8] = new HungryCat("КышБо серый", 150, 50);
        System.out.println("LOG \"кормление котов\"");

        dish = new Dish(350); // ставим миску
        if (lookIntoHonestEyesCats()) { //смотрим в честные глаза котиков и принимаем решение, наполнять еще миску или нет
            try {                                            //пытаемся наполнить миску. если удается тогда зовем котов.
                dish.addFoodToDish(350);         // наполняем миску
                ringTheBell();                               // стучим по миске
                System.out.println("В миске осталось " + dish.getCurrentFilling() + " единиц еды.");
            } catch (DishCustomException e) {
                System.out.println(e);
            }
        }
        if (lookIntoHonestEyesCats()) { //смотрим в честные глаза котиков и принимаем решение, наполнять еще миску или нет
            try {                                            //пытаемся наполнить миску. если удается тогда зовем котов.
                dish.addFoodToDish(250);         // наполняем миску
                ringTheBell();                               // стучим по миске
                System.out.println("В миске осталось " + dish.getCurrentFilling() + " единиц еды.");
            } catch (DishCustomException e) {
                System.out.println(e);
            }
        }
        if (lookIntoHonestEyesCats()) { //смотрим в честные глаза котиков и принимаем решение, наполнять еще миску или нет
            try {                                            //пытаемся наполнить миску. если удается тогда зовем котов.
                dish.addFoodToDish(250);         // наполняем миску
                ringTheBell();                               // стучим по миске
                System.out.println("В миске осталось " + dish.getCurrentFilling() + " единиц еды.");
            } catch (DishCustomException e) {
                System.out.println(e);
            }
        }
        //dish.decreaseFoodInDish(350);  // пытаемся взять из миски еду которой там нет
    }

    public static void ringTheBell() {
        for (int i = 0; i < hc.length; i++) {                   // Созываем всю араву на обед
            if (hc[i].offerToEat(dish)) {
                System.out.println(charVal_f + " Кот по имени "
                        + hc[i].name + " покушал(а)... Сытость увеличена до "
                        + (100 - ((double) (hc[i].appetite - hc[i].currentFilling) / hc[i].appetite) * 100) + "%");
            }
        }
    }

    public static boolean lookIntoHonestEyesCats() {
        for (int i = 0; i < hc.length; i++) {                   // Созываем всю араву на обед
            if (hc[i].isHungry()) {
                System.out.println(charVal_n + " " + charVal_a + " " + charVal_n + " Еще остались голодные коты. Наполните миску снова!");
                return true;
            }
        }
        System.out.println(charVal_s + " Все коты сыты!");
        return false;
    }
}
