package sort;

/**
 * 插入排序：将数组分为两部分，一部分为已排好序，另一部分为未被排好序的部分。每次将排好序的区域拓展一个index，然后将未排好序区域的第一个数插入排好序的
 * 区域。
 */
public class InsertionSort extends Sort{
    public InsertionSort(int[] arr){
        super(arr);
    }

    /**
     * 设置index为有序区域的拓展位置；
     * 设置value记录当前被进行insertion sort的数的值；
     * 设置mark为该数调整后应被插入的位置，默认值为当前位置；
     * 在mark位置的前一个数比当前数大的情况下，不断前移mark，直到前一个数比value小，此时mark位置为value应被插入的位置。
     * 同时，在比较过程中，mark-1位的数如果比mark位大，说明当将value插入之后，mark-1位的数应在mark位上，要向后移一位。
     */
    @Override
    public void sort() {
        if (arr == null || arr.length < 2) return;
        for (int index = 1; index < arr.length; index ++){
            int mark = index;
            int value = arr[index];//当前数的值
            while (mark > 0 && arr[mark-1] > value) arr[mark] = arr[--mark]; //找到第一个比value大的数的位置。
            arr[mark] = value;
        }
    }
}
