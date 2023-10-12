package com.epam.collections.queue;

import java.util.*;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> dishOrder = new ArrayList<>();
        Queue<Integer> dishesOnTheTable = new ArrayDeque<>();
        for (int i = 1; i <= numberOfDishes; i++) {
            dishesOnTheTable.add(i);
        }
        Queue<Integer> temporaryDeque = new ArrayDeque<>();
        int stepCounter = 0;
        while (dishOrder.size() != numberOfDishes) {
            stepCounter++;
            if (stepCounter % everyDishNumberToEat == 0) {
                dishOrder.add(dishesOnTheTable.remove());
            } else {
               temporaryDeque.add(dishesOnTheTable.remove());
            }
            if (dishesOnTheTable.isEmpty()) {
                dishesOnTheTable.addAll(temporaryDeque);
                temporaryDeque.clear();
            }
        }
        return dishOrder;
    }

    public static void main(String[] args) {
        DishOrderDeterminer dishOrderDeterminer = new DishOrderDeterminer();
        dishOrderDeterminer.determineDishOrder(10, 3);
    }
}
