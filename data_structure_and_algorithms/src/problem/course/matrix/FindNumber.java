package problem.course.matrix;

/**
 * 在排好序的矩阵中找数
 * 一个数，比当前数大，就往下走，比当前数小，就往左走。
 */
public class FindNumber {
    public boolean isFound(int num, int[][] matrix){
        int i=0; int j=matrix[0].length-1;
        while (j<matrix[0].length && i<matrix.length && j>=0 && i>=0){
            if (matrix[i][j] == num) return true;
            if (matrix[i][j] > num ) j--;
            else if(matrix[i][j] < num) i++;
        }
        return false;
    }
}
