package com.epam.mjc.collections.set;

import java.util.HashSet;
import java.util.Set;

public class SetCombinationCreator {

    public Set<String> createSetCombination(Set<String> firstSet, Set<String> secondSet, Set<String> thirdSet) {
        Set<String> resultSet = new HashSet<>();

        // Добавляем элементы, которые присутствуют в первом и втором наборах, но не в третьем
        for (String element : firstSet) {
            if (secondSet.contains(element) && !thirdSet.contains(element)) {
                resultSet.add(element);
            }
        }

        // Добавляем элементы, которые присутствуют только в третьем наборе
        for (String element : thirdSet) {
            if (!firstSet.contains(element) && !secondSet.contains(element)) {
                resultSet.add(element);
            }
        }

        return resultSet;
    }
}
