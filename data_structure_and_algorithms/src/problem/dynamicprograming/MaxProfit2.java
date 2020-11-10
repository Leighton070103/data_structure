package problem.dynamicprograming;

/**
 * Leetcode 剑指offer63.股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class MaxProfit2 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int min = prices[0];
        int max = 0;
        for (int i = 1; i<prices.length; i++){
            max = Math.max(prices[i] - min, max);
            min = Math.min(prices[i], min);
        }
        return max;
    }
}
