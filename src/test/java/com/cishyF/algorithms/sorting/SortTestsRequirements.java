package com.cishyF.algorithms.sorting;

public interface SortTestsRequirements {

    void nullTest(SortingAlgorithm algorithm);
    void emptyArrayTest(SortingAlgorithm algorithm);
    void arrayOfOneElementTest(SortingAlgorithm algorithm);
    void arrayOfTwoElementsTest(SortingAlgorithm algorithm);
    void randomTests(SortingAlgorithm algorithm);
}
