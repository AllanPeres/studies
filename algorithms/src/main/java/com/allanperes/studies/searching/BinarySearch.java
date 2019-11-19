package com.allanperes.studies.searching;

public class BinarySearch {

    public int search(int[] array, int target) {
        return this.binarySearch(array, array.length, target);
    }

    private int binarySearch(int[] array, int length, int target) {
        int max = length - 1;
        int min = 0;
        int guess;
        while(max >= min) {
            guess = (max + min) / 2;;
            if (array[guess] == target) {
                return guess;
            } else if (array[guess] > target) {
                max = guess - 1;
            } else {
                min = guess + 1;
            }
        }
        return -1;
    }
}
