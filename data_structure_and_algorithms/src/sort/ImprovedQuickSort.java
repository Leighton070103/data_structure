package sort;

import java.util.Stack;

import static util.NumUtil.randomNum;
import static util.NumUtil.swap;

public class ImprovedQuickSort extends Sort {
    public ImprovedQuickSort(int[] arr) {
        super(arr);
    }

    @Override
    public void sort() {
        Stack<Integer> tmp = new Stack<>();
        int left;
        int right;
        cacheLeftRight(tmp, 0, arr.length - 1);

        while (!tmp.empty()) {
            right = tmp.pop();
            left = tmp.pop();

            int[] results = partition(left, right);
            if (left < results[0]) cacheLeftRight(tmp, left, results[0]);
            if (results[1] < right) cacheLeftRight(tmp, results[1], right);
        }

    }

    private void cacheLeftRight(Stack<Integer> stack, int left, int right) {
        stack.push(left);
        stack.push(right);
    }

    int[] partition(int left, int right) {
        int num = arr[randomNum(left, right)];
        int rightPtr = right + 1;
        int leftPtr = left - 1;
        int nPtr = left;

        while (nPtr < rightPtr) {
            if (arr[nPtr] > num) {
                swap(arr, nPtr, --rightPtr);
            } else if (arr[nPtr] < num) swap(arr, nPtr++, ++leftPtr);
            else nPtr++;
        }
        return new int[]{leftPtr, rightPtr};
    }


}
