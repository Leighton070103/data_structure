package problem.dynamicprograming;

import static java.lang.Math.max;

/**
 * Leet code 123: 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit m = new MaxProfit();

        System.out.println(m.maxProfit2(new int[]{5,2,3,0,3,5,6,8,1,5}));
    }

    /**
     * 解法1（击败百分之十三）：以当前点为两次交易的断点，计算收益的最大值，和所存储的maxprofit进行比较。
     * min记录所遍历的prices中的最小值，max存储尚未遍历的数组中的最大值。
     * 对于第i天，其收益的最大值为1～i天的最大值减去最小值 + i~prices.length的最大值减去当天的prices[i]。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices.length <1 ) return 0;
        int min = prices[0];
        int maxProfit = 0;
        int firstMax = 0;
        Integer max = getMax(0, prices);//当前点之后的最大值
        for (int i=0; i<prices.length; i++){
            min = Math.min(prices[i], min);
            firstMax = Math.max(firstMax, prices[i] - min);
            maxProfit = Math.max(maxProfit, firstMax  +  max - prices[i]);
            if(prices[i] == max) max = getMax(i+1, prices);
        }

        return maxProfit;
    }

    /**
     * 解法2（击败百分之九十七）：沿用解法1的思路，加入函数极值的思想。
     * 为了方便比较，将max换位maxIndex。
     * 1. prices随i单增，最大收益为prices[prices.length-1] - prices[0];
     * 2. prices随i单增或毫无波动，最大收益为0；
     * 3. 在prices随着天数i有增有减的情况下，最大收益必定是一至两个极大值减去一至两个极小值，因此其实只要考虑极大值和极小值就可以了。
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices.length < 1) return 0;
        int min;
        int maxProfit = 0;
        int firstMax = 0;
        int maxIndex = 0;
        int i = 0;
        while (i+1<prices.length && prices[i] >= prices[i+1]) i++;
        min = prices[i];
        while (i < prices.length) {
            //Ascending
            if (i + 1 < prices.length && prices[i] < prices[i + 1]) {
                min = Math.min(prices[i], min);
                while (i + 1 < prices.length && prices[i] <= prices[i + 1]) i++;
            } //Equals
            else {
                //Descending or at the last element
                    firstMax = Math.max(firstMax, prices[i] - min);
                    while (i + 1 < prices.length && prices[i] >= prices[i + 1]) i++;
                    if (maxIndex <= i) maxIndex = getMaxIndex(i + 1, prices);
                    maxProfit = Math.max(maxProfit, firstMax + prices[maxIndex] - prices[i]);
                    min = Math.min(prices[i], min);
                    i++;
            }
        }

        return maxProfit;
    }

    public int getMax(int start, int[] arr) {
        if (start >= arr.length - 1) return 0;
        int max = arr[start];
        for (int i = start; i < arr.length; i++) max = Math.max(arr[i], max);
        return max;
    }

    public int getMaxIndex(int start, int[] arr) {
        if (start >= arr.length - 1) return arr.length - 1;
        int maxIndex = start;
        for (int i = start; i < arr.length; i++) maxIndex = arr[i] > arr[maxIndex] ? i : maxIndex;
        return maxIndex;
    }


    /**
     * 解法3：抄的大佬的做法
     * 假定一天可以进行两次买入卖出，对四次买入卖出分别列式。
     * @param prices
     * @return
     */
    public int mathSolve(int[] prices) {
        if (prices.length < 1) return 0;
        int s1 = -prices[0];
        int s2 = Integer.MIN_VALUE;
        int s3 = Integer.MIN_VALUE;
        int s4 = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; ++i) {
            s1 = max(s1, -prices[i]); //截止至第i天进行一笔交易的最低成本
            s2 = max(s2, s1 + prices[i]); //截止至第i天进行一笔交易的最高收益
            s3 = max(s3, s2 - prices[i]); //在进行了一笔最高收益的前提下，进行第二次买入后的最高金额
            s4 = max(s4, s3 + prices[i]); //在进行了一笔最高收益的前提下，进行第二次买入后卖出的最高金额
        }
        return max(0, s4);

    }
}
