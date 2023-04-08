package com.cishyF.algorithms.sorting;

public final class InsertionSort implements SortingAlgorithm {

    private static SortingAlgorithm instance;

    private InsertionSort() {}

    public static SortingAlgorithm getInstance() {
        if (instance == null)
            instance = new InsertionSort();
        return instance;
    }

    @Override
    public <T extends Comparable> void sort(T[] arr) {

         if (arr == null)
             return;

        for (int j = 1; j < arr.length; j++) {
            T key = arr[j];
            int i = j - 1;
            while (i >= 0 && (arr[i].compareTo(key) > 0)) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
    }
}
