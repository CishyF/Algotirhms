package com.cishyF.algorithmsTests;

import com.cishyF.algorithms.sorting.InsertionSort;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.DoubleStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class InsertionSortTest {

    @Test
    public void nullTest() {

        InsertionSort.sort(null);
    }

    @Test
    public void emptyArrayTest() {
         Integer[] emptyArray = {};

         Integer[] arrayAfterSorting = emptyArray.clone();
         InsertionSort.sort(arrayAfterSorting);

         assertArrayEquals(emptyArray, arrayAfterSorting);
    }

    @Test
    public void arrayOfOneElementTest() {
        double randomElement = Math.random() * 1000;

        Double[] arrayOfOneElement = {randomElement};

        Double[] arrayAfterSorting = arrayOfOneElement.clone();
        InsertionSort.sort(arrayAfterSorting);

        assertArrayEquals(arrayOfOneElement, arrayAfterSorting);
    }

    @Test
    public void arrayOfTwoElementsTest() {
        String s1 = "abc";
        String s2 = "bca";

        String[] arrayOfTwoElements = {s2, s1};
        String[] arrayAfterSorting = arrayOfTwoElements.clone();
        InsertionSort.sort(arrayAfterSorting);

        String[] correctArray = {s1, s2};

        assertArrayEquals(arrayAfterSorting, correctArray);
    }

    @RepeatedTest(15)
    public void randomTests() {
        Double[] randomArray = DoubleStream.generate(() -> Math.random() * 1000)
                                           .limit(10000)
                                           .boxed()
                                           .toArray(Double[]::new);

        Double[] arrayAfterSorting = randomArray.clone();
        InsertionSort.sort(arrayAfterSorting);

        Double[] correctArray = randomArray.clone();
        Arrays.sort(correctArray);

        assertArrayEquals(arrayAfterSorting, correctArray);
    }

}
