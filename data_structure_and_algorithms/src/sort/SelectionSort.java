package sort;

import static util.NumUtil.swap;

/**
 * 选择排序：不稳定。
 * 每一趟在n-i+1（i=1，2，…n-1）个记录中选取关键字最小的记录作为有序序列中第i个记录。
 */
public class SelectionSort extends Sort {

    public SelectionSort(int[] arr){
        super(arr);
    }

    /**
     * start指向无序区域的开始，minPos表示无序区域中最小的数。
     */
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
