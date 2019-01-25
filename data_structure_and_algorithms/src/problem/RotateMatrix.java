package problem;

import java.util.Scanner;

import static util.NumUtil.*;
import static util.PrintUtil.printMatrix;

public class RotateMatrix {

    int[][] matrix;
    RotateMatrix(int[][] matrix){
        this.matrix = matrix;
    }

    void rotate(){
        int start = 0;
        int end = matrix.length - 1;
        while ( start < end) rotateOneCircle(start++, end--);
    }

    void rotateOneCircle(int start, int end){
        for (int i = 0; i < end - start; i++){
            int tmp = matrix[end-i][start];
            matrix[end-i][start] = matrix[end][end-i];
            matrix[end][end-i] = matrix[start + i][end];
            matrix[start + i][end] = matrix[start][start + i];
            matrix[start][start + i] = tmp;
        }
    }

    public static void main(String[] args){
        System.out.println("Rotate Matrix===");
        System.out.println();
        System.out.print("Enter side length: ");
        Scanner scanner = new Scanner(System.in);
        int sideLen = scanner.nextInt();
        System.out.println("Generating matrix...");
        System.out.println();
        int[][] matrix = orderedMatrix(10, sideLen);
        printMatrix(matrix);
        System.out.println();
        System.out.println("Rotating...");
        System.out.println();
        RotateMatrix rotateMatrix = new RotateMatrix(matrix);
        rotateMatrix.rotate();
        printMatrix(matrix);
    }
}
