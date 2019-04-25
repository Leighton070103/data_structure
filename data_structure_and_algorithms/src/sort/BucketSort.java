package sort;

/**
 * 桶排序：将数组分到有限数量的桶里。
 * 最佳效率为O(n)
 * 数据差距大时，空间利用率低，且效率低。
 */
public class BucketSort extends Sort {
    int[] buckets;

    /**
     * 数组的最大值
     * @param arr
     * @param max
     */
    public BucketSort(int[] arr, int max) {
        super(arr);
        buckets = new int[max+1];
        for (int i = 0; i < buckets.length; i++) buckets[i] = 0;
    }

    @Override
    public void sort() {
        //根据arr[i]的值增加桶里数字的数量。
        for (int i = 0; i < arr.length; i++) buckets[arr[i]]++;
        int nPtr = 0;
        int value = 0;//当前桶所代表的值
        //将桶里的值重新放入数组。
        while (nPtr < arr.length ){
            int count = buckets[value];
            if (count > 0) {
                while (count > 0) arr[nPtr + (--count)] = value;
                nPtr = nPtr + buckets[value];
            }
            value ++;
        }
    }
}
