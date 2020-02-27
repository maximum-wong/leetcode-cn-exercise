package cn.kstar.leetcode;

/**
 * <h6>打家劫舍</h6>
 *
 * <p>你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * <br/>影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * </p>
 * <p>给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。</p>
 * <pre><b>Examples: </b>
 * <b>Example1: </b>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。偷窃到的最高金额 = 1 + 3 = 4 。
 * 
 * <b>Example2: </b>
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * </pre>
 */
public class LeetCode198 {

    /**
     * <h6>动态规划法</h6>
     * 
     * <p><b>解题思路：</b>
     * <br/>如果数组长度为1，就打劫第一家
     * <br/>如果数组长度为2，就打劫钱最多的那家
     * <br/>如果数组长度为3及以上，考虑打劫第i家的时候，要比较打劫第i-1家获取的钱和打劫第i家、第i-2家共同获取钱的多少
     * <br/>动态方程为：dp[i]=max(dp[i-1], nums[i]+dp[i-2])</p>
     * @param  nums
     * @return int
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        if (len == 1) { // 如果数组长度为1，就打劫第一家
            return nums[0];
        } else if (len == 2) { // 如果数组长度为2，就打劫钱最多的那家
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }

        // 如果数组长度为3及以上,考虑打劫第i家的时候，要比较打劫第i-1家获取的钱和打劫第i家、第i-2家共同获取钱的多少
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = dp[0] > nums[1] ? dp[0] : nums[1];
        for (int i = 2; i < len; i++) {
            dp[i] = (dp[i - 1] > nums[i] + dp[i - 2]) ? dp[i - 1] : (nums[i] + dp[i - 2]);
        }
        return dp[len - 1];
    }
}
