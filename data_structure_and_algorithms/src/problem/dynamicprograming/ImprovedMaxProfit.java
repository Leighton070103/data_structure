package problem.dynamicprograming;

import datastructure.LinkedList;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;


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


        public int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k==0) return 0;
        List<Integer> points = new ArrayList<>();
        points.add(prices[0]);
        int m = 1;
        while (m<prices.length-1){
            if(prices[m] < prices[m+1]){
                points.add(prices[m]);
                while (m+1<prices.length && prices[m] < prices[m+1]) m++;
            }else if(prices[m] > prices[m+1]){
                points.add(prices[m]);
                while (m+1<prices.length && prices[m] > prices[m+1]) m++;
            }else m++;
        }
        points.add(prices[prices.length-1]);
        if(points.size() == 2) return Math.max(0, points.get(points.size()-1) - points.get(0));

        k = min(points.size()/2 +1, k);

        int[] costs = new int[k];

        int[] trans = new int[k];
        for (int i =0; i<k; i++){
            costs[i] = Integer.MIN_VALUE;
            trans[i] = Integer.MIN_VALUE;
        }
        costs[0] = -points.get(0);

        for(int j = 0; j<points.size(); j++){
            int price = points.get(j);
            costs[0] = max(costs[0], -price);
            trans[0] = max(trans[0], price + costs[0]);
            for (int i=1; i<k; i++){
                costs[i] = max(costs[i], trans[i-1] - price);
                trans[i] = max(trans[i], price + costs[i]);
            }
        }
        return max(0, trans[trans.length-1]);
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
//    public int maxProfit(int k, int[] prices) {
//        if (prices.length < 1 || k==0) return 0;
//        k = min((prices.length + 1) / 2, k);
//         ArrayList<Integer> costs = new ArrayList<>();
//         ArrayList<Integer> trans = new ArrayList<>();
//
//       costs.add(-prices[0]);
//       trans.add(0);
//
//        for (int j = 0; j < prices.length; j++) {
//            int price = prices[j];
//            int cost = costs.get(0);
//            int tran = trans.get(0);
//            cost = max(cost, -price);
//            tran = max(tran, price + cost);
//            costs.set(0, cost);
//            trans.set(0, tran);
//
//            int limit = min((j+1)/2 + 1, k) ;
//
//            for (int i = 1; i < limit; i++) {
//                int prevTrans = trans.get(i-1);
//                if (i >= costs.size() ) {
//                   cost = max(Integer.MIN_VALUE, prevTrans - price);
//                   tran = max(Integer.MIN_VALUE, price + cost);
//                   costs.add(cost);
//                   trans.add(tran);
//
//                } else {
//                    cost = costs.get(i);
//                    tran = trans.get(i);
//                    cost= max(cost, prevTrans - price);
//                    tran = max(tran, price + cost);
//                    costs.set(i, cost);
//                    trans.set(i, tran);
//                }
//            }
//        }
//        return max(0, trans.get(trans.size()-1));
//    }
}
