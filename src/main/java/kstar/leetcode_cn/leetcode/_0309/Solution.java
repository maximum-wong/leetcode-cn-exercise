package kstar.leetcode_cn.leetcode._0309;

/**
 * <h6>动态规划法</h6>
 * <p><strong>状态分为：</strong>
 * <ol>dp[i][0]为手上持有股票的最大收益</ol>
 * <ol>dp[i][1]为手上不持有股票且在冷冻期的累计最大收益</ol>
 * <ol>dp[i][2]为手上不持有股票且不在冷冻期的累计最大收益</ol>
 * <strong>状态转方程：</strong>
 * <ol>dp[i][0]=max(dp[i-1][0], dp[i-1][2]-prices[i])</ol>
 * <ol>dp[i][1]=dp[i-1][0]+prices[i]</ol>
 * <ol>dp[i][2]=max(dp[i-1][1], dp[i-1][2])</ol>
 * <br/>第n天的收益为max(dp[n-1][0], dp[n-1][1], dp[n-1][2])，由于手中持有股票无意义，则为max(dp[n-1][1], dp[n-1][2])
 * </p>
 */
public class Solution {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        
        // 初始化第0天的值
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int i = 1; i < n; ++i) {
            int newf0 = Math.max(f0, f2 - prices[i]);
            int newf1 = f0 + prices[i];
            int newf2 = Math.max(f1, f2);
            f0 = newf0;
            f1 = newf1;
            f2 = newf2;
        }

        return Math.max(f1, f2);
    }
}
