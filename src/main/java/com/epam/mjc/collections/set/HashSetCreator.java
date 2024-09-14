package com.epam.mjc.collections.set;

import java.util.HashSet;
import java.util.List;

public class HashSetCreator {

    public HashSet<Integer> createHashSet(List<Integer> sourceList) {
        HashSet<Integer> resultSet = new HashSet<>();

        for (Integer x : sourceList) {
            if (x % 2 == 0) {
                // Для четных чисел делим на 2, пока не получим нечетное число
                while (x % 2 == 0) {
                    resultSet.add(x);
                    x /= 2;
                }
                resultSet.add(x); // Добавляем последнее нечетное число
            } else {
                // Для нечетных чисел добавляем само число и его удвоенное значение
                resultSet.add(x);
                resultSet.add(2 * x);
            }
        }

        return resultSet;
    }
}
