package kstar.leetcode;

/**
 * <h6>买卖股票的最佳时机
 * <br/>Best Time to Buy and Sell Stock</h6>
 *
 * <p>给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <br/>Say you have an array for which the <em>i</em><sup>th</sup> element is the price of a given stock on day <em>i</em>.</p>
 * <p>如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <br/>If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.</p>
 * <p>注意你不能在买入股票前卖出股票。
 * <br/>Note that you cannot sell a stock before you buy one.</p>
 * <pre><b>Example 1: </b>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * &nbsp;&nbsp;注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * &nbsp;&nbsp;Not 7-1 = 6, as selling price needs to be larger than buying price.
 * 
 * <b>Example 2: </b>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * In this case, no transaction is done, i.e. max profit = 0.
 * </pre>
 */
public class LeetCode121 {

    /**
     * <h6>动态规划法</h6>
     * 
     * <p>解题思路：前i天最大收益=max{前i-1天的最大收益, 前i天的价格-前i-1天中的最小价格}
     * <br/>状态方程为：dp[i]=max{dp[i-1], prices[i]-min}</p>
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int length = prices.length;
        int[] dp = new int[length];
        int min = prices[0];
        for (int i = 1; i < length; i++) {
            dp[i] = (dp[i - 1] > (prices[i] - min)) ? dp[i - 1] : prices[i] - min;
            min = (min < prices[i]) ? min : prices[i];
        }

        return dp[length - 1];
    }
    
    /**
     * <h6>动态规划法（优化）</h6>
     * 
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int pre = 0;
        int min = prices[0];
        for (int i = 1, length = prices.length; i < length; i++) {
            pre = pre > prices[i] - min ? pre : prices[i] - min;
            min = min < prices[i] ? min : prices[i];
        }

        return pre;
    }
}
