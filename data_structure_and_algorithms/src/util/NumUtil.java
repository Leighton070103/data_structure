package util;

import java.util.Random;

public class NumUtil {
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[][] randomMatrix(int row, int col, int bound){
        int[][] matrix = new int[row][col];
        for (int i = 0; i<row; i++){
            matrix[i] = ArrayUtil.randomArr(col, 100);
        }
        return matrix;
    }

    public static int[][] randomMatrix(int row, int col){
        return randomMatrix(row, col, 100);
    }



    public static int[][] orderedMatrix(int start, int sideLength){
        int[][] matrix = new int[sideLength][sideLength];
        for (int i=0; i<sideLength; i++){
            matrix[i] = ArrayUtil.orderedArr(i*sideLength + start, sideLength);
        }
        return matrix;
    }

    public static int[][] orderedMatrix(int start, int row, int col){
        int[][] matrix = new int[row][col];
        for (int i=0; i<row; i++){
            matrix[i] = ArrayUtil.orderedArr(i*col + start, col);
        }
        return matrix;
    }

    public static int randomNum(){
        return randomNum(10000);
    }

    /**
     * TODO:看看random的用法
     * @param min
     * @param max
     * @return
     */
    public static int randomNum(int min, int max){
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }
    public static int randomNum(int bound){
        Random random = new Random();
        return random.nextInt(bound);
    }

}
