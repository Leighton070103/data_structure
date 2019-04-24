package problem.matrix;

import java.util.Scanner;

import static util.PrintUtil.printMatrix;

public class FindNumInSortedMatrix {

    public static void main(String[] args) {
        System.out.println("Matrix===");
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Matrix row: ");
//        int row = scanner.nextInt();
//        System.out.print("Matrix column: ");
//        int column = scanner.nextInt();
//        System.out.println("Generating matrix....");
//        System.out.println("============");
        int[][] matrix = new int[][] {
                {0, 1, 2, 5},
                {2, 3, 4, 7},
                {4, 4, 4, 8},
                {5, 7, 7, 9}

        };
        printMatrix(matrix);
        FindNumInSortedMatrix findNum = new FindNumInSortedMatrix(matrix);
        System.out.print("Enter number: ");
        int num = scanner.nextInt();
        while (num != -1){
            System.out.println(findNum.findNum(num) ? "Has this number." : "Dont have this number");
            System.out.print("Enter number: ");
            num = scanner.nextInt();
        }

    }

    int[][] matrix;

    FindNumInSortedMatrix(int[][] matrix){
        this.matrix = matrix;
    }

    boolean findNum(int num){
        int rEnd = matrix.length - 1;
        int cEnd = matrix[0].length - 1;

        int row = rEnd;
        int col = 0;
        while (row != 0 && col != cEnd){
            if (matrix[row][col] == num) return true;
            if (matrix[row][col] > num) row --;
            if (matrix[row][col] < num) col++;
        }
        return false;
    }
}
