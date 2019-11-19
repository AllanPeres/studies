package com.allanperes.studies.searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinearSearchTest {

    private final LinearSearch linearSearch = new LinearSearch();

    @Test
    void should_ReturnIndexMinusOne_when_DontFind() {
        int[] array = new int[0];
        int expectedIndex = -1;
        int actualIndex = linearSearch.search(array, 0);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void should_ReturnIndexOfValue_when_FindValue() {
        int[] array = new int[]{1};
        int expectedIndex = 0;
        int actualIndex = linearSearch.search(array, 1);
        assertEquals(expectedIndex, actualIndex);
    }
}
