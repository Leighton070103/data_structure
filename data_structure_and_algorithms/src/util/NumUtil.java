package util;

import java.util.Random;

public class NumUtil {
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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

    public static int[][] randomMatrix(int row, int col, int bound){
        int[][] matrix = new int[row][col];
        for (int i = 0; i<row; i++){
            matrix[i] = randomArr(col, 100);
        }
        return matrix;
    }

    public static int[][] randomMatrix(int row, int col){
        return randomMatrix(row, col, 100);
    }



    public static int[][] orderedMatrix(int start, int sideLength){
        int[][] matrix = new int[sideLength][sideLength];
        for (int i=0; i<sideLength; i++){
            matrix[i] = orderedArr(i*sideLength + start, sideLength);
        }
        return matrix;
    }

    public static int[] orderedArr(int start, int length){
        int[] arr = new int[length];
        for (int i=0; i<length; i++) arr[i] = start + i;
        return arr;
    }

    public static int[] randomArr(){
        return randomArr(randomNum());
    }

    public static int randomNum(){
        return randomNum(10000);
    }

    public static int randomNum(int min, int max){
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }
    public static int randomNum(int bound){
        Random random = new Random();
        return random.nextInt(bound);
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
}
