package problem.course;

import problem.Problem;

import java.util.Arrays;

import static util.ArrayUtil.copyArray;
import static util.ArrayUtil.randomArr;

/**
 * 要求：
 * 给定一个数组，求排序后，相邻两数的最大差值。
 * 不能用非基于比较的排序，时间复杂度O(N)
 */
public class MaxGap extends Problem {

    public static void main(String[] args){
//        int[] arr = new int[]{3, 1, 6, 2, 7};
        int[] arr = randomArr();
        verify(copyArray(arr));
        MaxGap m = new MaxGap(arr);
        long start = System.currentTimeMillis();
        m.solve();
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }

    static void verify(int[] arr){
        Arrays.sort(arr);
        int gap = 0;
        for (int i=0; i<arr.length-1; i++) gap = Math.max(gap, arr[i+1] - arr[i]);
        System.out.println("Gap is: " + gap);
    }
    int[] arr;
    int max;
    int min;
    Bucket[] buckets;

    /**
     * 1.准备桶：有n个数，就准备n+1个桶
     * 2.最小值放在0号桶，最大值放在n号桶
     * 3.这样一来，必存在一个空桶，使得桶左边的最大值，与桶右边的最小值，差值>=一个桶的range。以此保证gap最大的数必不来自于同一个桶。
     * @param arr
     */
    public MaxGap(int[] arr){
        this.arr = arr;
        max = arr[0];
        min = arr[0];
        buckets = new Bucket[arr.length+1];
        for (int i = 1; i<arr.length; i++){
            min = arr[i] < min ? arr[i]:min;
            max = arr[i] > max? arr[i]:max;
            buckets[i] = new Bucket();
        }
        buckets[arr.length] = new Bucket();
        buckets[0] = new Bucket();
        buckets[0].insert(min);
        buckets[arr.length].insert(max);
    }

    /**
     * 遍历数组，将数组分别放入不同的桶中。
     * lastMax：上一个桶中最大的数
     */
    @Override
    public void solve() {
        for (int i = 0; i < arr.length; i++){
            int value = arr[i];
            buckets[getBucketNum(value)].insert(value);
        }
        int gap = 0;
        int lastMax = buckets[0].getMax();
        for (int i = 1; i < arr.length; i++){
            if (!buckets[i].isEmpty) {
                gap = Math.max(gap, buckets[i].getMin() - lastMax);
                lastMax = buckets[i].getMax();
            }
        }
        System.out.println(gap);

    }

    /**
     * 最后一个桶与第一个桶的中间所隔桶个数为arr.length，相对长度为max-min；
     * val与min桶相对间隔为val - min;
     * 设val所在桶标号为x，显然有(val-min)：（max-min) = (x-0):(n-0)
     * @param val
     * @return
     */
    private int getBucketNum(int val){
        return (val - min) * arr.length / (max-min);
    }

    /**
     * 桶，存储进入桶的最大值和最小值
     */
    private class Bucket{
        boolean isEmpty;
        int min;
        int max;
        Bucket(){
            isEmpty = true;
        }

        public void insert(int value){
            if (isEmpty){
                min = value;
                max = value;
                isEmpty = false;
            }
            else {
                min = value < min ? value:min;
                max = value > max ? value:max;
            }
        }

        public boolean isEmpty(){
            return isEmpty;
        }

        public int getMax(){
            return max;
        }

        public int getMin(){
            return min;
        }
    }
}
