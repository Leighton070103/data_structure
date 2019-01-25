package util;

public class PrintUtil {
    public static void printArr(int[] arr){
        System.out.print("{");
        printArrWithoutBrakets(arr);
        System.out.println("}");
    }

    public static void printArrWithoutBrakets(int[] arr){
        for (int i: arr) System.out.print(i + "; ");
    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0; i<matrix.length; i++) {
            printArrWithoutBrakets(matrix[i]);
            System.out.println();
        }
    }

    public static void printNum(int num){
        System.out.print(num + "; ");
    }
}
