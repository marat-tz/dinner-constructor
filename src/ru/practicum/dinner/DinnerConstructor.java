package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    private Map<String, ArrayList<String>> dishes = new HashMap<>();

    public boolean checkType(String type) {
        return this.dishes.containsKey(type);
    }

    public void addDishes(String type, String dish) {
        ArrayList<String> temp;

        if (this.dishes.containsKey(type)) {
            temp = this.dishes.get(type);

            if (temp.contains(dish)) {
                System.out.println("Блюдо " + dish + " уже содержится в списке.");
                System.out.println("-".repeat(20));

            } else {
                temp.add(dish);
                this.dishes.put(type, temp);
                System.out.println("В тип " + type + " добавлено блюдо " + dish);
                System.out.println("-".repeat(20));
            }

        } else {
            temp = new ArrayList<>();
            temp.add(dish);
            this.dishes.put(type, temp);
            System.out.println("В тип " + type + " добавлено блюдо " + dish);
            System.out.println("-".repeat(20));
        }
    }

    public void generateCombinations(int numberOfCombos, List<String> dishTypesParam) {
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        ArrayList<String> dishesTypes;

        try {
            dishesTypes = (ArrayList<String>) dishTypesParam;
        } catch (Exception exc) {
            System.out.println("В метод generateCombinations был передан не ArrayList");
            throw exc;
        }

        for (int i = 0; i < numberOfCombos; i++) {
            int count = 0;
            result.append("[");
            for (String type : dishesTypes) {
                ArrayList<String> dish = this.dishes.get(type);
                result.append(dish.get(random.nextInt(dish.size())));

                if (count < dishesTypes.size() - 1) {
                    result.append(", ");
                    count++;
                }
            }

            result.append("]");
            System.out.println("Комбо " + (i + 1));
            System.out.println(result);
            result.setLength(0);

            }

        System.out.println("-".repeat(20));

        }

    }

