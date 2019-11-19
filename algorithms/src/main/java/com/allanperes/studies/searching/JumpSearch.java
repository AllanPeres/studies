package com.allanperes.studies.searching;

public class JumpSearch {

    public int search(int[] array, int target) {
        return jumpSearch(array, array.length, target);
    }

    private int jumpSearch(int[] array, int length, int target) {
        int index = 0;
        int blockSize = extractBlockJump(length);

        while (array[index] <= target && (index + blockSize) < length) {
            index += blockSize;
            if (index > length - 1) {
                return -1;
            }
        }

        for (int iterator = index; iterator > index - blockSize; iterator--) {
            if (array[iterator] == target) {
                return iterator;
            }
        }
        return -1;
    }

    private int extractBlockJump(int length) {
        return (int) Math.round(Math.sqrt(length));
    }
}
