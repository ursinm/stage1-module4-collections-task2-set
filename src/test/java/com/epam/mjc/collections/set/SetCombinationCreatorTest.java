package com.epam.mjc.collections.set;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetCombinationCreatorTest {

    public static Stream<Arguments> testCases() {
        return Stream.of(
                // Тест для случая с полностью пустыми множествами
                Arguments.of("WithAllEmptySets",
                        new HashSet<>(),
                        new HashSet<>(),
                        new HashSet<>(),
                        Set.of()),

                // Непустое пересечение первого и второго множеств, пустое третье множество
                Arguments.of("WithNonEmptyIntersectionOfFirstAndSecondSetsAndEmptyThirdSet",
                        new HashSet<>(Set.of("Java", "SortedSet", "Map", "Collections", "Iterable", "Set", "NavigableSet")),
                        new HashSet<>(Set.of("Queue", "SortedSet", "NavigableSet", "List", "Set", "Iterator", "Comparator")),
                        new HashSet<>(),
                        Set.of("SortedSet", "NavigableSet", "Set")),

                // Непустое пересечение первого и второго множеств, элементы третьего множества повторяются в первом и втором
                Arguments.of("WithNonEmptyIntersectionOfFirstAndSecondSetsAndThirdSetOnlyNonUniqueElements",
                        new HashSet<>(Set.of("Java", "SortedSet", "Map", "Collections", "Iterable", "Set", "NavigableSet")),
                        new HashSet<>(Set.of("Queue", "SortedSet", "NavigableSet", "List", "Set", "Iterator", "Comparator")),
                        new HashSet<>(Set.of("Java", "Iterable", "Comparator")),
                        Set.of("SortedSet", "NavigableSet", "Set")),

                // Пустое пересечение первого и второго множеств, третье множество содержит уникальные элементы
                Arguments.of("WithEmptyIntersectionOfFirstAndSecondSetsAndThirdSetWithUniqueElements",
                        new HashSet<>(Set.of("Java", "SortedSet", "Map", "Collections", "Iterable", "Set", "NavigableSet")),
                        new HashSet<>(Set.of("Queue", "List", "Iterator", "Comparator")),
                        new HashSet<>(Set.of("TreeSet", "HashSet", "LinkedHashSet", "Collections", "Iterable")),
                        Set.of("TreeSet", "HashSet", "LinkedHashSet")),

                // Непустое пересечение первого и второго множеств, третье множество содержит уникальные и повторяющиеся элементы
                Arguments.of("WithNonEmptyIntersectionOfFirstAndSecondSetsAndNonEmptyThirdSet",
                        new HashSet<>(Set.of("Java", "SortedSet", "Map", "Collections", "Iterable", "Set", "NavigableSet")),
                        new HashSet<>(Set.of("Queue", "SortedSet", "NavigableSet", "List", "Set", "Iterator", "Comparator")),
                        new HashSet<>(Set.of("TreeSet", "HashSet", "LinkedHashSet", "Collections", "Iterable")),
                        Set.of("SortedSet", "NavigableSet", "Set", "TreeSet", "HashSet", "LinkedHashSet")),

                // Тест с дублирующимися элементами в наборе
                Arguments.of("WithDuplicatedElementsInSets",
                        new HashSet<>(Set.of("A", "B", "C", "C")),
                        new HashSet<>(Set.of("A", "C", "D")),
                        new HashSet<>(Set.of("C", "D", "E")),
                        Set.of("A", "E"))
        );
    }

    @ParameterizedTest(name = "createSetCombination_{0}_Test")
    @MethodSource(value = "testCases")
    void createSetCombinationTest(String name,
                                  Set<String> firstSet,
                                  Set<String> secondSet,
                                  Set<String> thirdSet,
                                  Set<String> expectedSetCombination) {

        SetCombinationCreator setCombinationCreator = new SetCombinationCreator();
        Set<String> actualSetCombination = setCombinationCreator.createSetCombination(firstSet, secondSet, thirdSet);
        assertEquals(expectedSetCombination, actualSetCombination);
    }
}
