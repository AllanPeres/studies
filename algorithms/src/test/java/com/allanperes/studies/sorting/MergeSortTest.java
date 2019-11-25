package com.allanperes.studies.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortTest {

    @Test
    void should_sortArray_when_receiveUnsortedArray() {
        int[] arr = new int[]{3,4,8,9,10,7,25,2, 26};
        int[] expectedArray = new int[]{2,3,4,7,8,9,10,25, 26};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        assertArrayEquals(expectedArray, arr);
    }
}
