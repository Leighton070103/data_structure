package util;

import static util.NumUtil.randomNum;

public class ArrayUtil {
    public static int[] orderedArr(int start, int length){
        int[] arr = new int[length];
        for (int i=0; i<length; i++) arr[i] = start + i;
        return arr;
    }

    public static int[] randomArr(int length){
        int[] arr = new int[length];
        for (int i = 0; i<length; i++){
            arr[i] = randomNum();
        }
        return arr;
    }

    public static int[] randomArr(int length, int bound){
        int[] arr = new int[length];
        for (int i = 0; i<length; i++){
            arr[i] = randomNum(bound);
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static int[] randomArr(){
        return randomArr(randomNum());
    }

    public static int[] orderedRandGapArray(int length, int start, int gapBound){
        int[] arr = new int[length];
        arr[0] = start;
        for (int i = 1; i < arr.length; i++) arr[i] = arr[i-1] + randomNum(gapBound);
        return arr;
    }
}
