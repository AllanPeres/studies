package com.allanperes.studies.searching;

public class LinearSearch {

    public int search(int[] array, int wantedValue) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == wantedValue) {
                return i;
            }
        }
        return -1;
    }
}
