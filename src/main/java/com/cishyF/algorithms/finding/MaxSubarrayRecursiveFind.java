package com.cishyF.algorithms.finding;

/**
 * Алгоритм, использующий принцип "Разделяй и властвуй", для нахождения максимального подмассива.
 * Работает за {@code Θ(nlgn)}
 */
public final class MaxSubarrayRecursiveFind {

    public static SubarrayInfo find(int[] A, int low, int high) {
        if (low == high) {
            return new SubarrayInfo(low, high, A[low]);
        } else {
            int mid = Math.floorDiv(high + low, 2);

            SubarrayInfo leftHalfMaxSubarray = find(A, low, mid);
            SubarrayInfo rightHalfMaxSubarray = find(A, mid + 1, high);
            SubarrayInfo crossMaxSubarray = findCross(A, low, mid, high);

            if (leftHalfMaxSubarray.getSum() >= rightHalfMaxSubarray.getSum() &&
                    leftHalfMaxSubarray.getSum() >= crossMaxSubarray.getSum()) {
                return leftHalfMaxSubarray;
            } else if (rightHalfMaxSubarray.getSum() >= leftHalfMaxSubarray.getSum() &&
                    rightHalfMaxSubarray.getSum() >= crossMaxSubarray.getSum()) {
                return rightHalfMaxSubarray;
            } else {
                return crossMaxSubarray;
            }
        }
    }

    private static SubarrayInfo findCross(int[] A, int low, int mid, int high) {
        int maxLeftSum = Integer.MIN_VALUE;
        int leftSum = 0;
        int leftIndex = 0;
        for (int i = mid; i >= low; i--) {
            leftSum += A[i];
            if (leftSum > maxLeftSum) {
                maxLeftSum = leftSum;
                leftIndex = i;
            }
        }

        int maxRightSum = Integer.MIN_VALUE;
        int rightSum = 0;
        int rightIndex = 0;
        for (int i = mid + 1; i <= high; i++) {
            rightSum += A[i];
            if (rightSum > maxRightSum) {
                maxRightSum = rightSum;
                rightIndex = i;
            }
        }

        return new SubarrayInfo(leftIndex, rightIndex, maxLeftSum + maxRightSum);
    }
}
