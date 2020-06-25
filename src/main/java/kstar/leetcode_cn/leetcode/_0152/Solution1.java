package kstar.leetcode_cn.leetcode._0152;

/**
 * <h6>动态规划法</h6>
 * <p>时间复杂度: O(n); 空间复杂度: O(1)</p>
 * <p>动态转移方程：if nums[i]>=0, dp[i][1] = max(nums[i], nums[i]*dp[i-1][1]); dp[i][0] = min(nums[i], nums[i]*dp[i-1][0])<br/>
 * if nums[i]<0, dp[i][1] = max(nums[i], nums[i]*dp[i-1][0]); dp[i][0] = min(nums[i], nums[i]*dp[i-1][1])</p>
 */
public class Solution1 {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int preMax = nums[0];
        int preMin = nums[0];

        int curMax;
        int curMin;

        int res = nums[0];
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] >= 0) {
                curMax = Math.max(preMax * nums[i], nums[i]);
                curMin = Math.min(preMin * nums[i], nums[i]);
            } else {
                curMax = Math.max(preMin * nums[i], nums[i]);
                curMin = Math.min(preMax * nums[i], nums[i]);
            }

            res = Math.max(res, curMax);

            preMax = curMax;
            preMin = curMin;
        }
        return res;
    }
}
