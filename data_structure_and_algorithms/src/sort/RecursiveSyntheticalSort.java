package sort;

import static util.NumUtil.randomNum;
import static util.NumUtil.swap;

/**
 * 递归版本的综合排序。
 */
public class RecursiveSyntheticalSort extends Sort {
    public RecursiveSyntheticalSort(int[] arr) {
        super(arr);
    }

    @Override
    public void sort() {
        sort(0, arr.length - 1);

    }

    /**
     * 数组长度小于60时，采用插入排序。
     * 数组长度大于60时，采用快排。
     * @param left
     * @param right
     */
    void sort(int left, int right) {
        if (right - left < 60) {
            insertionSort(left, right);
            return;
        }
        int num = arr[randomNum(left, right)];
        int rightPtr = right + 1;
        int leftPtr = left - 1;
        int nPtr = left;

        while (nPtr < rightPtr) {
            if (arr[nPtr] > num) swap(arr, nPtr, --rightPtr);
            else if (arr[nPtr] < num) swap(arr, nPtr++, ++leftPtr);
            else nPtr++;
        }
        sort(left, leftPtr);
        sort(rightPtr, right);
    }

    void insertionSort(int start, int end) {
        for (int index = start + 1; index <= end; index++) {
            int mark = index;
            int value = arr[index];
            while (mark > 0 && arr[mark - 1] > value) arr[mark] = arr[--mark]; //找到第一个比value大的数的位置。
            arr[mark] = value;
        }
    }
}
