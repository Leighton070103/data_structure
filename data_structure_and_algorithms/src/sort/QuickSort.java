package sort;

import static util.NumUtil.randomNum;
import static util.NumUtil.swap;

/**
 * 不稳定算法;
 * 时间复杂度nlogn
 * 快速排序：选取一个标准数，通过这个标准数将数组内的数分为大于标准数和小于标准数两部分。
 */
public class QuickSort extends Sort {
    public QuickSort(int[] arr) {
        super(arr);
    }

    @Override
    public void sort() {
        sort(0, arr.length - 1);
    }

    /**
     * 通过random选取一个标准数，进行快排。
     * nPtr，rPtr，lPtr分别指当前指针，左指针，右指针。
     * 当前数小于val时,将其与左边界所指的下一个数进行交换，拓宽左边界。 由于左边界的下一个数要么是当前数，要么是与val值相等的数，所以交换完后，当前
     * 指针所指向的数必然是有序的，因此直接将指针往下移动。
     * 当前数大于val时，将其与右边界所指向的前一个数进行交换，拓宽右边界。由于右边界的下一个数多半是无序的，所以交换后的nPtr所指向的值与val的关系不确
     * 定，因此不移动指针。
     * 当前数等于val时，直接移动nPtr。
     * 对于介于lPtr与rPtr之间（不包括lPtr和rPtr所指向的数）的数，必然全部等于val，因此在下一次快排中将其忽略。
     * @param left 本次sort的第一个数的下标
     * @param right 最后一个数的下标
     */
    void sort(int left, int right) {
        if (left >= right) return;
        int val = arr[randomNum(left, right)];
        int rPtr = right + 1;
        int lPtr = left - 1;
        int nPtr = left;

        while (nPtr < rPtr) {
            if (arr[nPtr] > val) swap(arr, nPtr, -- rPtr);
            else if (arr[nPtr] < val) swap(arr, nPtr ++, ++ lPtr);
            else nPtr ++;
        }
        sort(left, lPtr);
        sort(rPtr, right);
    }
}
