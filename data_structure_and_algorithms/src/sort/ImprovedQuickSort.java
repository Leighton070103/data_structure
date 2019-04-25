package sort;

import java.util.Stack;
import static util.NumUtil.randomNum;
import static util.NumUtil.swap;

/**
 * 快排，将递归改成非递归。
 */
public class ImprovedQuickSort extends Sort {
    public ImprovedQuickSort(int[] arr) {
        super(arr);
    }

    /**
     * 递归快排事实上是将两个part一直细分到两个part长度都为1时才开始下一个未排序的part，所以根据这个思想，把每次partition的结果，即下次
     * partition所用的参数压入栈中，以此模仿递归的缓存。
     */
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

    /**
     * 将左右放入缓存。
     * @param stack
     * @param left
     * @param right
     */
    private void cacheLeftRight(Stack<Integer> stack, int left, int right) {
        stack.push(left);
        stack.push(right);
    }

    /**
     * 同普通快排的partition，但返回左指针和右指针。
     * @param left partition起始点
     * @param right partition终结点
     * @return
     */
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
