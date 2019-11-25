package com.allanperes.studies.sorting;

public class InsertionSort {

    public void sort(int[] arr) {
        for (int index = 1; index < arr.length; index++) {
            int reversedIndex = index;
            while (reversedIndex > 0 && arr[reversedIndex - 1] > arr[reversedIndex]) {
                int key = arr[reversedIndex];
                arr[reversedIndex] = arr[reversedIndex - 1];
                arr[reversedIndex - 1] = key;
                reversedIndex--;
            }
        }
    }
}
