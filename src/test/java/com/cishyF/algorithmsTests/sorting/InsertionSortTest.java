package com.cishyF.algorithmsTests.sorting;

import com.cishyF.algorithms.sorting.InsertionSort;
import com.cishyF.algorithms.sorting.SortingAlgorithm;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.DoubleStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class InsertionSortTest implements SortTestRequirements {

    private static final SortingAlgorithm INSERTION_SORT = InsertionSort.getInstance();

    @Test
    public void nullTest() {

        INSERTION_SORT.sort(null);
    }

    @Test
    public void emptyArrayTest() {
         Integer[] emptyArray = {};

         Integer[] arrayAfterSorting = emptyArray.clone();
         INSERTION_SORT.sort(arrayAfterSorting);

         assertArrayEquals(emptyArray, arrayAfterSorting);
    }

    @Test
    public void arrayOfOneElementTest() {
        double randomElement = Math.random() * 1000;

        Double[] arrayOfOneElement = {randomElement};

        Double[] arrayAfterSorting = arrayOfOneElement.clone();
        INSERTION_SORT.sort(arrayAfterSorting);

        assertArrayEquals(arrayOfOneElement, arrayAfterSorting);
    }

    @Test
    public void arrayOfTwoElementsTest() {
        String s1 = "abc";
        String s2 = "bca";

        String[] arrayOfTwoElements = {s2, s1};
        String[] arrayAfterSorting = arrayOfTwoElements.clone();
        INSERTION_SORT.sort(arrayAfterSorting);

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
        INSERTION_SORT.sort(arrayAfterSorting);

        Double[] correctArray = randomArray.clone();
        Arrays.sort(correctArray);

        assertArrayEquals(arrayAfterSorting, correctArray);
    }

}
