package problem.matrixs;

import static util.PrintUtil.printMatrix;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 */
public class ScareScrow {
    public void rotate(int[][] matrix) {
        int min = 0;//行a，列b
        int max = matrix.length -1;

        while (min < max){
            for (int i = 0; i <max - min; i++){
                int tmp = matrix[min][min+i];
                matrix[min][min+i] = matrix[max-i][min];
                matrix[max-i][min] = matrix[max][max-i];
                matrix[max][max-i] = matrix[min+i][max];
                matrix[min+i][max] = tmp;
            }
            min ++;
            max --;
        }

    }

    public static void main(String[] args){
        int[] [] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14,12,16}
        };
        ScareScrow s = new ScareScrow();
        s.rotate(matrix);
        printMatrix(matrix);




    }
}
