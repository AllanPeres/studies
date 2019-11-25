package com.allanperes.studies.sorting;

public class SelectionSort {

    private void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    private int indexOfMinimum(int[] arr, int startIndex, int n) {
        int minValue = arr[startIndex];
        int minIndex = startIndex;
        for (int i = minIndex + 1; i < n; i++) {
            if (arr[i] < minValue) {
                minIndex = i;
                minValue = arr[i];
            }
        }
        return minIndex;
    }

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = indexOfMinimum(arr, i, arr.length);
            swap(arr, i, index);
        }
    }
}
