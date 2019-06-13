package problem.dynamicprograming;

import static java.lang.Math.max;
import static java.lang.Math.min;


/**
 * Leet code 188. 买卖股票的最佳时机 IV
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class ImprovedMaxProfit {

    public static void main(String[] args) {
        ImprovedMaxProfit m = new ImprovedMaxProfit();

        System.out.println(m.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }

    //    public int maxProfit(int k, int[] prices) {
//        if (prices.length < 1) return 0;
//        k = min(prices.length/2 +1, k);
//
//        int[] costs = new int[k];
//
//        int[] trans = new int[k];
//        for (int i =0; i<k; i++){
//            costs[i] = Integer.MIN_VALUE;
//            trans[i] = Integer.MIN_VALUE;
//        }
//        costs[0] = -prices[0];
//
//        for(int j = 0; j<prices.length; j++){
//            int price = prices[j];
//            costs[0] = max(costs[0], -price);
//            trans[0] = max(trans[0], price + costs[0]);
//            for (int i=1; i<k; i++){
//                costs[i] = max(costs[i], trans[i-1] - price);
//                trans[i] = max(trans[i], price + costs[i]);
//            }
//        }
//        return max(0, trans[trans.length-1]);
//    }
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 1 || k==0) return 0;
        k = min((prices.length + 1) / 2, k);

        int[] costs = new int[k];

        int[] trans = new int[k];
        for (int i = 0; i < k; i++) {
            costs[i] = Integer.MIN_VALUE;
            trans[i] = Integer.MIN_VALUE;
        }
        costs[0] = -prices[0];

        for (int j = 0; j < prices.length; j++) {
            int price = prices[j];
            costs[0] = max(costs[0], -price);
            trans[0] = max(trans[0], price + costs[0]);
            for (int i = 1; i < k; i++) {
                if (2*i > j) {
                    costs[i] = costs[i-1];
                    trans[i] = trans[i-1];

                } else {
                    costs[i] = max(costs[i], trans[i - 1] - price);
                    trans[i] = max(trans[i], price + costs[i]);
                }
            }
        }
        return max(0, trans[trans.length - 1]);
    }
}
