package com.allanperes.studies.sorting;

public class MergeSort {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int p, int r) {
        int q;
        if (p < r) {
            q = (p + r) / 2;
            sort(arr, p, q);
            sort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    private void merge(int[] arr, int p, int q, int r) {
        int[] secondArr = new int[arr.length];
        int i, j, k;
        k = 0;
        i = p;
        j = q + 1;
        while (i <= q && j <= r) {
            if (arr[i] < arr[j]) {
                secondArr[k++] = arr[i++];
            } else {
                secondArr[k++] = arr[j++];
            }
        }
        while (i <= q) {
            secondArr[k++] = arr[i++];
        }
        while (j <= r) {
            secondArr[k++] = arr[j++];
        }
        for(i = r; i >= p; i--) {
            arr[i] = secondArr[--k];
        }
    }
}
