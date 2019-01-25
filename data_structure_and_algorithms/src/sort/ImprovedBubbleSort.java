package sort;

import static util.NumUtil.swap;

public class ImprovedBubbleSort extends Sort {

    public ImprovedBubbleSort(int[] arr){
        super(arr);
    }

    @Override
    public void sort() {
        for (int end = arr.length - 1; end > 0; end --){
            int sortedPos = -1;
            int tmp = -1;
            for (int i = 0; i < end; i++){
                if (arr[i] > arr[i+1] ) {
//                    tmp = arr[i+1];
//                    arr[i+1] = arr[i];
                    swap(arr, i, i+1);
                    sortedPos = i+1;
                }
            }
            end = sortedPos + 1;
            if (sortedPos == -1) break;//如果sortedPos为-1则说明完全没有发生过交换。
        }
    }
}
