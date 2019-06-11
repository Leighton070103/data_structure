package sort;

import static util.NumUtil.swap;

/**
 * 冒泡排序：可以通过改变是否在值相同时交换变成稳定的排序算法。
 */
public class BubbleSort extends Sort {

    public BubbleSort(int[] arr){
        super(arr);
    }

    @Override
    public void sort() {
        for (int end = arr.length -1; end > 0; end --){
            for (int i = 0; i < end; i++){
                if (arr[i] > arr[i+1] ) {
                    swap(arr, i, i+1);
                }
            }
        }
    }
}
