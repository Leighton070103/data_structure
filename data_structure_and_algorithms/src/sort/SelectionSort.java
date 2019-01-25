package sort;

import static util.NumUtil.printArr;
import static util.NumUtil.swap;

public class SelectionSort extends Sort {

    public SelectionSort(int[] arr){
        super(arr);
    }
    @Override
    public void sort() {
        for (int start = 0; start < arr.length; start++){
            int minPos = start;
            for (int i = start; i<arr.length; i++){
                minPos = arr[i] < arr[minPos] ? i : minPos;
            }
            swap(arr, minPos, start);
        }
    }
}
