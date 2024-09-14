package com.epam.mjc.collections.set;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetOfSquaresCreatorTest {

    public static Stream<Arguments> testCases() {
        return Stream.of(
                // Пустой список
                Arguments.of("EmptySourceList",
                        List.of(),
                        2,
                        30,
                        Set.of()),

                // Квадраты чисел внутри и вне диапазона
                Arguments.of("WithSquaresFromAndNotFromRange",
                        List.of(-1, 5, 3, -3, 6, -7, -4, 2),
                        2,
                        30,
                        Set.of(25, 9, 16, 4)),

                // Квадраты на границах диапазона
                Arguments.of("WithSquaresOnTheRangeBounds",
                        List.of(-1, 5, 3, -3, 6, -7, -4, 2),
                        4,
                        25,
                        Set.of(4, 9, 16, 25)),

                // Все числа отрицательные
                Arguments.of("WithAllNegativeNumbers",
                        List.of(-3, -5, -7, -10),
                        0,
                        50,
                        Set.of(9, 25, 49)),

                // Широкий диапазон значений
                Arguments.of("WithLargeRange",
                        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9),
                        1,
                        100,
                        Set.of(1, 4, 9, 16, 25, 36, 49, 64, 81))
        );
    }

    @ParameterizedTest(name = "createSubsetOfSquares_{0}_Test")
    @MethodSource(value = "testCases")
    void createSubsetOfSquaresTest(String name,
                                   List<Integer> sourceList,
                                   int lowerBound,
                                   int upperBound,
                                   Set<Integer> expectedSubset) {

        SubsetOfSquaresCreator subsetOfSquaresCreator = new SubsetOfSquaresCreator();
        Set<Integer> actualSubset = subsetOfSquaresCreator.createSubsetOfSquares(sourceList, lowerBound, upperBound);
        assertEquals(expectedSubset, actualSubset);
    }
}
