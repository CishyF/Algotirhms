package com.cishyF.algorithmsTests;

import com.cishyF.algorithms.InsertionSort;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class InsertionSortTest {

    @Test
    public void emptyArrayTest() {
         Integer[] emptyArray = {};
         Integer[] arrayAfterSorting = InsertionSort.sort(emptyArray.clone());

         assertArrayEquals(emptyArray, arrayAfterSorting);
    }

    @Test
    public void arrayOfOneElementTest() {
        double randomElement = Math.random() * 1000;

        Double[] arrayOfOneElement = {randomElement};
        Double[] arrayAfterSorting = InsertionSort.sort(arrayOfOneElement.clone());

        assertArrayEquals(arrayOfOneElement, arrayAfterSorting);
    }

    @Test
    public void arrayOfTwoElementsTest() {
        String s1 = "abc";
        String s2 = "bca";

        String[] arrayOfTwoElements = {s2, s1};
        String[] arrayAfterSorting = InsertionSort.sort(arrayOfTwoElements.clone());

        String[] correctArray = {s1, s2};

        assertArrayEquals(arrayAfterSorting, correctArray);
    }

    @RepeatedTest(15)
    public void randomTests() {
        Double[] randomArray = DoubleStream.generate(() -> Math.random() * 1000)
                                           .limit(10000)
                                           .boxed()
                                           .toArray(Double[]::new);

        Double[] arrayAfterSorting = InsertionSort.sort(randomArray.clone());

        Double[] correctArray = Arrays.stream(randomArray.clone()).sorted().toArray(Double[]::new);

        assertArrayEquals(arrayAfterSorting, correctArray);
    }

}
