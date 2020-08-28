package kstar.leetcode_cn.leetcode._0121;

/**
 * <h6>动态规划法（优化）</h6>
 */
public class Solution2 {

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
