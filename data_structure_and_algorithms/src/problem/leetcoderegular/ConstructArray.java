package problem.leetcoderegular;


import static util.PrintUtil.printArr;

/**
 * Leetcode: 667优美的排列
 * 给定两个整数 n 和 k，你需要实现一个数组，这个数组包含从 1 到 n 的 n 个不同整数，同时满足以下条件：
 * ① 如果这个数组是 [a1, a2, a3, ... , an] ，那么数组 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数；.
 * ② 如果存在多种答案，你只需实现并返回其中任意一种
 */
public class ConstructArray {

    public static void main(String[] args) {
        ConstructArray ca = new ConstructArray();
        printArr(ca.constructArray(5, 2));
    }

    /**
     * 还是不能懒得做数学。。
     * @param n
     * @param k
     * @return
     */
    public int[] constructArray(int n, int k) {

        int[] result = new int[n];

        int i = 0;
        int num = 1;
        while (i<n){
            if (i<k+1){
                if(i%2 == 0) result[i] = num;
                else result[i] = (k+2-(num++));
            }
            else if(i==k+1){
                num = k+2;
                result[i] = num++;
            }
            else {
                result[i] = num++;
            }
            i++;
        }

        return result;
    }
}
