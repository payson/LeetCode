package mySolutions;

/**
 * Created by Payson Wu on 16/03/14.
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int result = 0;
        if (prices.length < 2) return result;
        int low = prices[0], high = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > high) {
                high = prices[i];
                result += high - low;
                low = high;
            } else if (prices[i] < low) {
                low = prices[i];
                high = prices[i];
            }
        }
        return result;
    }
}
