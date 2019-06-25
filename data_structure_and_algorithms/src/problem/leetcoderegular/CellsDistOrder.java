package problem.leetcoderegular;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import static util.PrintUtil.printMatrix;

/**
 * Leetcode 1030
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，
 * |r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 */
public class CellsDistOrder {

    public static void main(String[] args){
        CellsDistOrder c = new CellsDistOrder();
        printMatrix(c.allCellsDistOrder(2, 2, 0, 1)) ;
    }

    class Coordinate{
        int r;
        int c;
        public Coordinate(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R*C][2];
        int index = 1;


        return res;
    }

    void addToQueue(int r, int c, boolean[][] inQue, Queue<Coordinate> queue, int R, int C){
        if ( r<0 ||c <0 || r>=R || c>=C ||inQue[r][c]) return;
        inQue[r][c] = true;
        queue.add(new Coordinate(r, c));
    }

    int[][] solve2(int R, int C, int r0, int c0){
        int[][] res = new int[R*C][2];
        int index = 0;
        boolean[][] inQue = new boolean[R][C];
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(r0, c0));
        inQue[r0][c0] = true;
        int r;
        int c;
        while (index < R*C){
            Coordinate co = queue.poll();
            r = co.r;
            c = co.c;
            index = makePair(r, c, res, index);
            addToQueue(r+1, c, inQue, queue, R, C);
            addToQueue(r-1, c, inQue, queue, R, C);
            addToQueue(r, c+1, inQue, queue, R, C);
            addToQueue(r, c-1, inQue, queue, R, C);
        }

        return res;
    }

    public int[][] solve1(int R, int C, int r0, int c0){
        int[][] res = new int[R*C][2];
        int index = 0;
        for(int i = 0; i < R; i++) for(int j = 0; j < C; j++) res[index++] = new int[]{i, j};
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0)) - (Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0)) ;
            }
        });
        return res;
    }




    public int makePair(int r, int c, int[][] res, Integer index){
       res[index][0] = r;
       res[index++][1] = c;
       return index;
    }
}
