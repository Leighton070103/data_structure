package problem;


import util.PrintUtil;

import static util.NumUtil.swap;

public class NetherlandFlag extends Problem {

    int[] arr;
    int num;
    public NetherlandFlag(int[] arr, int num){
        this.arr = arr;
        this.num = num;
    }

    @Override
    public void solve() {
        int rightPtr = arr.length;
        int leftPtr = -1;
        int nPtr = 0;
        while (nPtr < rightPtr){
            if (arr[nPtr] > num) swap(arr, nPtr, --rightPtr);
            else if (arr[nPtr] < num) swap(arr, nPtr ++, ++leftPtr);
            else nPtr ++;
        }
        PrintUtil.printArr(arr);
    }
}
