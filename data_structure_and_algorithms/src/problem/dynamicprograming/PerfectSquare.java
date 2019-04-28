package problem.dynamicprograming;


import java.util.HashSet;
import java.util.Set;


/**
 * Leetcode 279 —— 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 */
class PerfectSquare {

    public static void main(String[] args){
        PerfectSquare square = new PerfectSquare();
       System.out.println(square.numSquares(216));
    }

    /**
     * 根据拉格朗日四平方数定理，一个整数可以表示为4个整数的平方和。
     * 也就是说，从n台阶往下走完全平方数阶，最多走四步。
     * 所以用step代表当前已走的步数，currentStages用于存储走了step步，能够到达的台阶数目（因为可能存在不同走法台阶数目相同的情况，所以采用Set过滤
     * 为了避免类似于“先走一步，再走九步”和“先走9步，再走1步”的情况，因此规定目前走的台阶数不得小于剩余台阶除以剩余步数的平均值。
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if(n==1) return 1;
        Set<Integer> currentStages = new HashSet<>();
        currentStages.add(n);
        Set<Integer> nextStages;
        for (int step = 1; step < 4; step ++){
            nextStages = new HashSet<>();
            int resStep = 4-step+1;
            for (Integer currentStage: currentStages){
                int max = getBase(currentStage);
                int min = getBase(currentStage/resStep);
                for (int difference = max; difference>= min; difference--){
                    int nextStage = currentStage - square(difference);
                    if (nextStage == 0) return step;
                    if (nextStage > 0) nextStages.add(nextStage);
                }
            }
            currentStages = nextStages;

        }
        return 4;
    }

    /**
     * 计算数的平方
     * @param val
     * @return
     */
    int square(int val){ return val * val;}

    /**
     * 返回最靠近该数的完全平方数的底数。
     * @param val
     * @return
     */
    int getBase(int val){
        return (int)Math.floor(Math.sqrt(val));
    }

}

