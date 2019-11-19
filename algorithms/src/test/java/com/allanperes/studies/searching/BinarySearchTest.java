package com.allanperes.studies.searching;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    private final BinarySearch binarySearch = new BinarySearch();

    @Test
    void should_ReturnMinusOne_when_DontExistsInArray() {
        int[] array = new int[]{1};
        int expectedIndex = -1;
        int actualIndex = binarySearch.search(array, 2);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void should_ReturnMiddleIndex_when_MiddleIndexMatched() {
        int[] array = new int[]{1,2,3};
        int expectedIndex = 1;
        int actualIndex = binarySearch.search(array, 2);
        assertEquals(expectedIndex, actualIndex);
    }

    @ParameterizedTest
    @MethodSource("createPairTargetIndex")
    void should_ReturnFindedIndex_when_PassedArrayContains(int target, int expectedIndex) {
        int[] array = new int[]{1, 3, 4, 5, 6, 7, 9};
        int actualIndex = binarySearch.search(array, target);
        assertEquals(expectedIndex, actualIndex);
    }

    private static Stream<Arguments> createPairTargetIndex() {
        return Stream.of(
                Arguments.of(7, 5),
                Arguments.of(3, 1),
                Arguments.of(9, 6)
        );
    }
}
