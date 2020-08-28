package kstar.leetcode_cn.leetcode._0714;

/**
 * <h6>动态规划法</h6>
 * <p>cash不持有股票时的最大利润；hold持有股票时的最大利润</p>
 * <p>cash=max(cash, hold+prices[i]-fee)</p>
 * <p>hold=max(cash, cash-prices[i])</p>
 */
public class Solution {

    public int maxProfit(int[] prices, int fee) {
        int cash = 0;
        int hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
