package ru.practicum.dinner;

import java.util.*;

public class DinnerConstructor {

    private Map<String, ArrayList<String>> dishes = new HashMap<>();

    public boolean checkType(String type) {
        if (this.dishes.containsKey(type)) {
            return true;
        }
        return false;
    }

    public void addDishes(String type, String dish) {
        ArrayList<String> temp;

        if (this.dishes.containsKey(type)) {
            temp = dishes.get(type);

            if (temp.contains(dish)) {
                System.out.println("Блюдо " + dish + " уже содержится в списке.");
                System.out.println("-".repeat(20));

            } else {
                temp.add(dish);
                dishes.put(type, temp);
                System.out.println("В тип " + type + " добавлено блюдо " + dish);
                System.out.println("-".repeat(20));
            }

        } else {
            temp = new ArrayList<>();
            temp.add(dish);
            dishes.put(type, temp);
            System.out.println("В тип " + type + " добавлено блюдо " + dish);
            System.out.println("-".repeat(20));
        }
    }

    public void addDishesTemp() {
        ArrayList<String> dishFirst = new ArrayList<>();
        ArrayList<String> dishSecond = new ArrayList<>();
        ArrayList<String> dishDrink = new ArrayList<>();

        dishFirst.add("Блюдо-1");
        dishFirst.add("Блюдо-2");
        dishFirst.add("Блюдо-3");

        dishSecond.add("Блюдо-1");
        dishSecond.add("Блюдо-2");
        dishSecond.add("Блюдо-3");

        dishDrink.add("Блюдо-1");
        dishDrink.add("Блюдо-2");
        dishDrink.add("Блюдо-3");

        dishes.put("Первое", dishFirst);
        dishes.put("Второе", dishSecond);
        dishes.put("Напиток", dishDrink);
    }

    public void generateCombinations(int numberOfCombos, ArrayList<String> dishesTypes) {
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        ArrayList<String> usedCombos = new ArrayList<>();

        for (int i = 0; i < numberOfCombos; i++) {
            boolean isComboInList = true;
            int count = 0;
            result.append("[");
            for (String type : dishesTypes) {
                ArrayList<String> dish = dishes.get(type); // получили массив блюд заданного типа их мапы
                result.append(dish.get(random.nextInt(dish.size()))); // случайным образом получили одно блюдо

                if (count < dishesTypes.size() - 1) {
                    result.append(", ");
                    count++;
                }
            }
            result.append("]");

            if (usedCombos.isEmpty()) { // если список пуст, то выводим комбинацию и сохраняем в список
                System.out.println("Комбо " + (i + 1));
                System.out.println(result);
                usedCombos.add(result.toString());

            } else {
                for (String temp : usedCombos) { // перебираем комбинации в поисках совпадений
                    if (!result.toString().equals(temp)) { // если совпадений нет
                        isComboInList = false;
                    }
                }

                if (!isComboInList) { // добавляем комбо в список
                    usedCombos.add(result.toString());
                    System.out.println("Комбо " + (i + 1));
                    System.out.println(result);
                }
            }
            result.setLength(0);
        }

        System.out.println("-".repeat(20));
    }

}
