package sort;

import static util.NumUtil.swap;

/**
 * 改造冒泡排序。
 */
public class ImprovedBubbleSort extends Sort {

    public ImprovedBubbleSort(int[] arr){
        super(arr);
    }

    /**
     * 如果经过某一次遍历后，完全没有发生过交换，则该数组其实已经是有序的了，就跳出循环。
     * 同时，记录最后一次发生交换的位置，该位置之后的数组也说明已经是有序。
     */
    @Override
    public void sort() {
        for (int end = arr.length - 1; end > 0; end --){
            int sortedPos = -1;
            for (int i = 0; i < end; i++){
                if (arr[i] > arr[i+1] ) {
                    swap(arr, i, i+1);
                    sortedPos = i+1;
                }
            }
            end = sortedPos + 1;
            if (sortedPos == -1) break;//如果sortedPos为-1则说明完全没有发生过交换。
        }
    }
}
