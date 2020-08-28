package kstar.leetcode_cn.leetcode._0122;

/**
 * <h6>峰谷法</h6>
 * <p>totalProfit=(height(peak1)-height(valley1))+...+(height(peakn)-height(valleyn))</p>
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxProfit = 0;
        while (i < prices.length - 1) {
            // 寻找谷底
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            // 寻找峰顶
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            // 求最大利润和
            maxProfit += peak - valley;
        }
        return maxProfit;
    }
}
