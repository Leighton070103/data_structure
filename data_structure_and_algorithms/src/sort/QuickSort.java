package sort;

import static util.NumUtil.randomNum;
import static util.NumUtil.swap;

public class QuickSort extends Sort {
    public QuickSort(int[] arr) {
        super(arr);
    }

    @Override
    public void sort() {
        sort(0, arr.length - 1);
    }

    void sort(int left, int right) {
        if (left >= right) return;
        int num = arr[randomNum(left, right)];
        int rightPtr = right + 1;
        int leftPtr = left - 1;
        int nPtr = left;

        while (nPtr < rightPtr) {
            if (arr[nPtr] > num) swap(arr, nPtr, -- rightPtr);
            else if (arr[nPtr] < num) swap(arr, nPtr ++, ++ leftPtr);
            else nPtr ++;
        }
        sort(left, leftPtr);
        sort(rightPtr, right);
    }
}
