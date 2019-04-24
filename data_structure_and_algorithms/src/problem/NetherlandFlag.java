package problem;

import util.PrintUtil;
import static util.NumUtil.swap;

/**
 * 荷兰国旗问题：
 * 给定一个数组arr，和一个数num。
 * 把小于num的数放在数组左边，等于num的数放在数组中间，大于num的数放在数组右边。
 * 额外空间复杂度O(1)，时间复杂度O(n)。
 */
public class NetherlandFlag extends Problem {

    int[] arr;
    int num;
    public NetherlandFlag(int[] arr, int num){
        this.arr = arr;
        this.num = num;
    }

    /**
     * 设两个指针，分别指向小于num区域的最后一个数和大于num区域的第一个数。
     * 遍历数组，如果遇上小于num的数，就将这个数与左指针的下一位数交换，左指针加一，拓宽小于区域范围。
     * 如果遇上大于num的数，就将这个数与右指针的前一位数交换，右指针加一，拓宽大于区域范围
     */
    @Override
    public void solve() {
        int rightPtr = arr.length;//初始时，无确定范围，右指针指向数组越界处。
        int leftPtr = -1;//同理。
        int nPtr = 0;

        while (nPtr < rightPtr){
            if (arr[nPtr] > num) swap(arr, nPtr, --rightPtr);
            else if (arr[nPtr] < num) swap(arr, nPtr ++, ++leftPtr);
            else nPtr ++;
        }
        PrintUtil.printArr(arr);
    }
}
