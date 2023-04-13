package com.cishyF.algorithms.sorting;

public final class MergeSort implements SortingAlgorithm {

    private static SortingAlgorithm instance;

    private MergeSort() {}

    public static SortingAlgorithm getInstance() {
        if (instance == null) {
            instance = new MergeSort();
        }
        return instance;
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {

        if (arr == null || arr.length < 2)
            return;
        mergeSort(arr, 0, arr.length - 1);
    }

    private <T extends Comparable<T>> void mergeSort(T[] arr, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    private <T extends Comparable<T>> void merge(T[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        T[] left = (T[]) new Comparable[n1];
        T[] right = (T[]) new Comparable[n2];

        System.arraycopy(arr, p, left, 0, n1);
        System.arraycopy(arr, q + 1, right, 0, n2);

        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (i == n1 || (j != n2 && left[i].compareTo(right[j]) >= 0)) {
                arr[k] = right[j++];
            } else {
                arr[k] = left[i++];
            }
        }
    }

    @Override
    public String toString() {
        return "MergeSort";
    }
}
