package sort;

public class BucketSort extends Sort {
    int[] buckets;

    public BucketSort(int[] arr, int max) {
        super(arr);
        buckets = new int[max+1];
        for (int i = 0; i < buckets.length; i++) buckets[i] = 0;
    }

    @Override
    public void sort() {
        for (int i = 0; i < arr.length; i++) buckets[arr[i]]++;
        int nPtr = 0;
        int value = 0;
        while (nPtr < arr.length ){
            int num = buckets[value];
            if (num > 0) {
                while (num > 0)arr[nPtr + (--num)] = value;
                nPtr = nPtr + buckets[value];
            }
            value++;
        }
    }
}
