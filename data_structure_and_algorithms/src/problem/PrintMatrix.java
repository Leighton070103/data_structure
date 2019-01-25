package problem;

import java.util.Scanner;

import static util.NumUtil.*;
import static util.PrintUtil.printMatrix;
import static util.PrintUtil.printNum;

public class PrintMatrix {

    public static void main(String[] args){
        System.out.println("Rotate Matrix===");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Matrix row: ");
        int row = scanner.nextInt();
        System.out.print("Matrix column: ");
        int column = scanner.nextInt();
        System.out.println("Generating matrix....");
        System.out.println("============");
        int[][] matrix = randomMatrix(row, column);
        printMatrix(matrix);
        PrintMatrix printMatrix = new PrintMatrix(matrix);
        System.out.println("Printing...");
        printMatrix.print();
    }

    int[][] matrix;

    PrintMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    void print() {
       int startRow = 0;
       int startCol = 0;
       int endRow = matrix.length - 1;
       int endCol = matrix[0].length - 1;
        while (startRow <= endRow){
            int row = startRow;
            int col = startCol;
            if (startCol == endCol){
                while (row <= endRow) printNum(matrix[row++][col]);
                break;
            }
            else if (startRow == endRow){
                while (col <= endCol) printNum(matrix[row][col++]);
                break;
            }
            else {
            while (col < endCol) printNum(matrix[row][col++]);
            while (row < endRow) printNum(matrix[row++][col]);
            while (col > startCol) printNum(matrix[row][col--]);
            while (row > startRow) printNum(matrix[row--][col]);
            startRow++;
            startCol++;
            endCol--;
            endRow--;}
        }
    }

}
