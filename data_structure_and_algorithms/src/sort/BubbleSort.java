package sort;

import static util.NumUtil.swap;

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
