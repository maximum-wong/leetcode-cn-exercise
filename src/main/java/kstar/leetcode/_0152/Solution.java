package kstar.leetcode._0152;

/**
 * <h6>动态规划法</h6>
 * <p>时间复杂度: O(n); 空间复杂度: O(n)</p>
 * <p>动态转移方程：if nums[i]>=0, dp[i][1] = max(nums[i], nums[i]*dp[i-1][1]); dp[i][0] = min(nums[i], nums[i]*dp[i-1][0])<br/>
 * if nums[i]<0, dp[i][1] = max(nums[i], nums[i]*dp[i-1][0]); dp[i][0] = min(nums[i], nums[i]*dp[i-1][1])</p>
 */
public class Solution {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[][] dp = new int[len][2];
        // 保存最大值
        dp[0][0] = nums[0];
        // 保存最小值
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                dp[i][0] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
                dp[i][1] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
            } else {
                dp[i][0] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
                dp[i][1] = Math.max(nums[i], dp[i - 1][0] * nums[i]);
            }
        }

        int res = dp[0][1];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i][1]);
        }

        return res;
    }
}
