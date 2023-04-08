package com.cishyF.algorithmsTests.sorting;

import com.cishyF.algorithms.sorting.SelectionSort;
import com.cishyF.algorithms.sorting.SortingAlgorithm;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.DoubleStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectionSortTest implements SortTestRequirements {

    private static final SortingAlgorithm SELECTION_SORT = SelectionSort.getInstance();

    @Test
    public void nullTest() {

        SELECTION_SORT.sort(null);
    }

    @Test
    public void emptyArrayTest() {
        Integer[] emptyArray = {};

        Integer[] arrayAfterSorting = emptyArray.clone();
        SELECTION_SORT.sort(arrayAfterSorting);

        assertArrayEquals(emptyArray, arrayAfterSorting);
    }

    @Test
    public void arrayOfOneElementTest() {
        double randomElement = Math.random() * 1000;

        Double[] arrayOfOneElement = {randomElement};

        Double[] arrayAfterSorting = arrayOfOneElement.clone();
        SELECTION_SORT.sort(arrayAfterSorting);

        assertArrayEquals(arrayOfOneElement, arrayAfterSorting);
    }

    @Test
    public void arrayOfTwoElementsTest() {
        String s1 = "abc";
        String s2 = "bca";

        String[] arrayOfTwoElements = {s2, s1};
        String[] arrayAfterSorting = arrayOfTwoElements.clone();
        SELECTION_SORT.sort(arrayAfterSorting);

        String[] correctArray = {s1, s2};

        assertArrayEquals(arrayAfterSorting, correctArray);
    }

    @RepeatedTest(30)
    public void randomTests() {
        Double[] randomArray = DoubleStream.generate(() -> Math.random() * 1000)
                .limit(10000)
                .boxed()
                .toArray(Double[]::new);

        Double[] arrayAfterSorting = randomArray.clone();
        SELECTION_SORT.sort(arrayAfterSorting);

        Double[] correctArray = randomArray.clone();
        Arrays.sort(correctArray);

        assertArrayEquals(arrayAfterSorting, correctArray);
    }

}

