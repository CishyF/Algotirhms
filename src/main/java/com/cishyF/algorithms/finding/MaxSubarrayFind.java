package com.cishyF.algorithms.finding;


/**
 * Алгоритм Кадане для нахождения максимального подмассива.
 * Работает за {@code Θ(n)}
 */
public final class MaxSubarrayFind {

    public static SubarrayInfo find(int[] A, int low, int high) {
        int leftIndex = 0;
        int sum = 0;
        SubarrayInfo maxSubarrayInfo = null;

        for (int rightIndex = low; rightIndex <= high; rightIndex++) {
            if (sum == 0) {
                leftIndex = rightIndex;
            }
            sum += A[rightIndex];
            if (maxSubarrayInfo == null || sum > maxSubarrayInfo.getSum()) {
                maxSubarrayInfo = new SubarrayInfo(leftIndex, rightIndex, sum);
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSubarrayInfo;
    }
}
