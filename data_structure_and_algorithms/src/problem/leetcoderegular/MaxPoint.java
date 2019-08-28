package problem.leetcoderegular;

import java.util.*;

/**
 * Leetcode 149: 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 */
public class MaxPoint {

    public static void main(String[] args){
        MaxPoint m = new MaxPoint();
        System.out.print(m.maxPoints(new int[][] {{1, 1}, {2, 2}, {3, 3}}));
    }

    public int method2(int[][] points){
        if (points.length <= 2) return points.length;
        int max = 2;
        boolean[] duplicated = new boolean[points.length];
        for (int i = 0; i<points.length-1; i++){
            if (duplicated[i]) continue;
            int curMax = 1;
            int duplicates = 0;
            HashMap<Pair, Integer> countMap = new HashMap<>();
            for (int k = 1; k+i < points.length; k++){
                if (samePoint(points[i], points[i+k])) {
                    duplicates ++;
                    duplicated[i+k] = true;
                }
                else {
                    Pair p = makePair(points[i+k][0] - points[i][0], points[i+k][1] - points[i][1]);
                    int count = countMap.containsKey(p) ? countMap.get(p) + 1 : 2;
                    countMap.put(p, count);
                    curMax = Math.max(count, curMax);
                }
            }
            max = Math.max(curMax + duplicates, max);
        }

        return max;
    }

    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        int max = 2;
        for (int i = 0; i<points.length-1; i++){
            int curMax = 1;
            int duplicates = 0;
            HashMap<Pair, Integer> countMap = new HashMap<>();
            for (int k = 1; k+i < points.length; k++){
                if (samePoint(points[i], points[i+k])) duplicates ++;
                else {
                    Pair p = makePair(points[i+k][0] - points[i][0], points[i+k][1] - points[i][1]);
                    int count = countMap.containsKey(p) ? countMap.get(p) + 1 : 2;
                    countMap.put(p, count);
                    curMax = Math.max(count, curMax);
                }
            }
            max = Math.max(curMax + duplicates, max);
        }

        return max;
    }

    boolean samePoint(int[] a, int [] b){
        return a[0] == b[0] && b[1] == a[1];
    }


    class Pair {

        int dx;
        int dy;

        Pair(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        @Override
        public boolean equals(Object obj) {
            Pair p = (Pair) obj;
            return p.dx == this.dx && this.dy == p.dy;
        }

        @Override
        public int hashCode() {
            StringBuilder sb = new StringBuilder();
            sb.append(dx);
            sb.append(dy);
            char[] charArr = sb.toString().toCharArray();
            int hash = 0;
            for (char c : charArr) {
                hash = hash * 131 + c;
            }
            return hash;
        }
    }

    Pair makeCoor(int[] point){
        return new Pair(point[0], point[1]);
    }

    Pair makePair(int x, int y){
        int gcd = gcd(x, y);
        if (gcd != 0){
            x /= gcd;
            y /= gcd;
        }

        if( x * y < 0 ) {
            y = x < 0 ? (-1) * y : y;
            x = x < 0 ? (-1) * x : x;
        }
        return new Pair(x, y);
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
