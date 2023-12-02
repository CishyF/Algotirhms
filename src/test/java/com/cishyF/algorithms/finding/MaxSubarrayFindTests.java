package com.cishyF.algorithms.finding;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxSubarrayFindTests {

    @Test
    public void shouldReturnFirstElementIfArrayContainsOneElement() {
        int[] array = new int[] {1};

        SubarrayInfo expected = new SubarrayInfo(0, 0, 1);
        SubarrayInfo actual = MaxSubarrayFind.find(array, 0, array.length - 1);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPositiveNumber() {
        int[] array = new int[] {-1, 2};

        SubarrayInfo expected = new SubarrayInfo(1, 1, 2);
        SubarrayInfo actual = MaxSubarrayFind.find(array, 0, array.length - 1);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFullArrayIfContainsOnlyPositive() {
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8};

        SubarrayInfo expected = new SubarrayInfo(0, 7, 36);
        SubarrayInfo actual = MaxSubarrayFind.find(array, 0, array.length - 1);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnMinElementIfArrayContainsOnlyNegative() {
        int[] array = new int[] {-2, -1, -3, -4, -5, -6, -7, -8};

        SubarrayInfo expected = new SubarrayInfo(1, 1, -1);
        SubarrayInfo actual = MaxSubarrayFind.find(array, 0, array.length - 1);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnMaxSubarray() {
        int[] array = new int[] {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};

        SubarrayInfo expected = new SubarrayInfo(7, 10, 43);
        SubarrayInfo actual = MaxSubarrayFind.find(array, 0, array.length - 1);

        assertEquals(expected, actual);
    }
}
