package com.cishyF.algorithmsTests.sorting;

import com.cishyF.algorithms.sorting.InsertionSort;
import com.cishyF.algorithms.sorting.MergeSort;
import com.cishyF.algorithms.sorting.SelectionSort;
import com.cishyF.algorithms.sorting.SortingAlgorithm;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.ThrowingConsumer;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortTests implements SortTestsRequirements {

    private static final SortingAlgorithm MERGE_SORT = MergeSort.getInstance();
    private static final SortingAlgorithm INSERTION_SORT = InsertionSort.getInstance();
    private static final SortingAlgorithm SELECTION_SORT = SelectionSort.getInstance();

    private final SortingAlgorithm[] arrayOfSortingAlgorithms = new SortingAlgorithm[] {
            INSERTION_SORT, SELECTION_SORT, MERGE_SORT
    };
    private final Stream<SortingAlgorithm> inputStreamForOneTimeTests = Arrays.stream(arrayOfSortingAlgorithms);
    private final Function<SortingAlgorithm, String> displayName = alg -> ("Current algorithm: " + alg);

    @TestFactory
    Stream<DynamicTest> dynamicNullTest() {

        ThrowingConsumer<SortingAlgorithm> testExecutor = this::nullTest;

        return DynamicTest.stream(inputStreamForOneTimeTests, displayName, testExecutor);
    }

    @Disabled
    @TestTemplate
    public void nullTest(SortingAlgorithm algorithm) {

        algorithm.sort(null);
    }

    @TestFactory
    Stream<DynamicTest> dynamicEmptyArrayTest() {

        ThrowingConsumer<SortingAlgorithm> testExecutor = this::emptyArrayTest;

        return DynamicTest.stream(inputStreamForOneTimeTests, displayName, testExecutor);
    }

    @Disabled
    @TestTemplate
    public void emptyArrayTest(SortingAlgorithm algorithm) {
         Integer[] emptyArray = {};

         Integer[] arrayAfterSorting = emptyArray.clone();
         algorithm.sort(arrayAfterSorting);

         assertArrayEquals(emptyArray, arrayAfterSorting);
    }

    @TestFactory
    Stream<DynamicTest> dynamicArrayOfOneElementTest() {

        ThrowingConsumer<SortingAlgorithm> testExecutor = this::arrayOfOneElementTest;

        return DynamicTest.stream(inputStreamForOneTimeTests, displayName, testExecutor);
    }

    @Disabled
    @TestTemplate
    public void arrayOfOneElementTest(SortingAlgorithm algorithm) {
        double randomElement = Math.random() * 1000;

        Double[] arrayOfOneElement = {randomElement};

        Double[] arrayAfterSorting = arrayOfOneElement.clone();
        algorithm.sort(arrayAfterSorting);

        assertArrayEquals(arrayOfOneElement, arrayAfterSorting);
    }

    @TestFactory
    Stream<DynamicTest> dynamicArrayOfTwoElementsTest() {

        ThrowingConsumer<SortingAlgorithm> testExecutor = this::arrayOfTwoElementsTest;

        return DynamicTest.stream(inputStreamForOneTimeTests, displayName, testExecutor);
    }

    @Disabled
    @TestTemplate
    public void arrayOfTwoElementsTest(SortingAlgorithm algorithm) {
        System.out.println(algorithm);
        String s1 = "abc";
        String s2 = "bca";

        String[] arrayOfTwoElements = {s2, s1};
        String[] arrayAfterSorting = arrayOfTwoElements.clone();
        algorithm.sort(arrayAfterSorting);

        String[] correctArray = {s1, s2};

        assertArrayEquals(arrayAfterSorting, correctArray);
    }

    @TestFactory
    Stream<DynamicTest> dynamicRandomTests() {

        Stream<SortingAlgorithm> inputStream = IntStream.rangeClosed(0, 44)
                                                        .mapToObj(i -> arrayOfSortingAlgorithms[i % 3]);
        ThrowingConsumer<SortingAlgorithm> testExecutor = this::randomTests;

        return DynamicTest.stream(inputStream, displayName, testExecutor);
    }

    @Disabled
    @TestTemplate
    public void randomTests(SortingAlgorithm algorithm) {
        Double[] randomArray = DoubleStream.generate(() -> Math.random() * 1000)
                                           .limit(10000)
                                           .boxed()
                                           .toArray(Double[]::new);

        Double[] arrayAfterSorting = randomArray.clone();
        algorithm.sort(arrayAfterSorting);

        Double[] correctArray = randomArray.clone();
        Arrays.sort(correctArray);

        assertArrayEquals(arrayAfterSorting, correctArray);
    }

}
