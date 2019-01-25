package problem;

public class MaxGap extends Problem {

    public static void main(String[] args){
        int[] arr = new int[]{3, 1, 6, 2, 7};
        MaxGap m = new MaxGap(arr);
        long start = System.currentTimeMillis();
        m.solve();
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }

    int[] arr;
    int max;
    int min;
    Bucket[] buckets;
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

    private int getBucketNum(int num){
        return (num - min)*arr.length/(max-min);
    }

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
