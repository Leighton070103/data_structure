package problem.matrix;

import java.util.Scanner;

import static util.NumUtil.*;
import static util.PrintUtil.*;

public class PrintMatrix {

    public static void main(String[] args) {
        System.out.println("Matrix===");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Matrix row: ");
        int row = scanner.nextInt();
        System.out.print("Matrix column: ");
        int column = scanner.nextInt();
        System.out.println("Generating matrix....");
        System.out.println("============");
        int[][] matrix = orderedMatrix(1, row, column);
        printMatrix(matrix);
        PrintMatrix printMatrix = new PrintMatrix(matrix);
        System.out.println("Printing...");
//        printMatrix.clockWisePrint();
        printMatrix.zigTagPrint();
    }

    int[][] matrix;

    PrintMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    void zigTagPrint() {
        int rowA = 0;
        int colA = 0;
        int rowB = 0;
        int colB = 0;
        int line = 0;
        while (!(rowA == matrix.length - 1 && colA == matrix[0].length - 1)) {
            for (int i = 0; i <= rowB - rowA; i++) {
                printNum(matrix[line % 2 == 1 ? rowA + i: rowB - i][line % 2 == 1 ? colA - i: colB + i]);
            }
            rowA = colA == matrix[0].length - 1? rowA + 1: rowA;
            colA = colA == matrix[0].length - 1? colA: colA + 1;
            colB = rowB == matrix.length - 1? colB + 1: colB;
            rowB = rowB == matrix.length - 1? rowB: rowB + 1;
            line++;
        }
        printNum(matrix[rowA][colA]);
    }

    void clockWisePrint() {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;
        while (startRow <= endRow) {
            int row = startRow;
            int col = startCol;
            if (startCol == endCol) {
                while (row <= endRow) printNum(matrix[row++][col]);
                break;
            } else if (startRow == endRow) {
                while (col <= endCol) printNum(matrix[row][col++]);
                break;
            } else {
                while (col < endCol) printNum(matrix[row][col++]);
                while (row < endRow) printNum(matrix[row++][col]);
                while (col > startCol) printNum(matrix[row][col--]);
                while (row > startRow) printNum(matrix[row--][col]);
                startRow++;
                startCol++;
                endCol--;
                endRow--;
            }
        }
    }

}
