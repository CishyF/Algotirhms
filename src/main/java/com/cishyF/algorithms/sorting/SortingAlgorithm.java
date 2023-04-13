package com.cishyF.algorithms.sorting;

public interface SortingAlgorithm {

    <T extends Comparable<T>> void sort(T[] arr);
}
