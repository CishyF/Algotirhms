package com.cishyF.algorithms.sorting;

public final class SelectionSort implements SortingAlgorithm {

    private static SortingAlgorithm instance;

    private SelectionSort() {}

    public static SortingAlgorithm getInstance() {
        if (instance == null)
            instance = new SelectionSort();
        return instance;
    }

    @Override
    public <T extends Comparable> void sort(T[] arr) {

        if (arr == null)
            return;

        for (int i = 0; i < arr.length - 1; i++) {
            T value = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }
            arr[i] = arr[minIndex];
            arr[minIndex] = value;
        }
    }
}
