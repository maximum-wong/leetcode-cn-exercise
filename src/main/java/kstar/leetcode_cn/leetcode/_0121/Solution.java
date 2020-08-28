package kstar.leetcode_cn.leetcode._0121;

/**
 * <h6>动态规划法</h6>
 * 
 * <p>解题思路：前i天最大收益=max{前i-1天的最大收益, 前i天的价格-前i-1天中的最小价格}
 * <br/>状态方程为：dp[i]=max{dp[i-1], prices[i]-min}</p>
 */
public class Solution {

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
}
