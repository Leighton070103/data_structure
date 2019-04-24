package sort;


public class InsertionSort extends Sort{
    public InsertionSort(int[] arr){
        super(arr);
    }
    @Override
    public void sort() {
        if (arr == null || arr.length < 2) return;
        for (int index = 1; index < arr.length; index ++){
            int mark = index;
            int value = arr[index];
            while (mark > 0 && arr[mark-1] > value) arr[mark] = arr[--mark]; //找到第一个比value大的数的位置。
            arr[mark] = value;
        }
    }
}
