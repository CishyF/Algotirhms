package com.cishyF.algorithms.finding;

public class SubarrayInfo {

    private final int leftIndex;
    private final int rightIndex;
    private final int sum;

    public SubarrayInfo(int leftIndex, int rightIndex, int sum) {
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
        this.sum = sum;
    }

    public int getLeftIndex() {
        return leftIndex;
    }

    public int getRightIndex() {
        return rightIndex;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "SubarrayInfo{" +
                "leftIndex=" + leftIndex +
                ", rightIndex=" + rightIndex +
                ", sum=" + sum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubarrayInfo that = (SubarrayInfo) o;

        if (leftIndex != that.leftIndex) return false;
        if (rightIndex != that.rightIndex) return false;
        return sum == that.sum;
    }

    @Override
    public int hashCode() {
        int result = leftIndex;
        result = 31 * result + rightIndex;
        result = 31 * result + sum;
        return result;
    }
}
