package kstar.leetcode_cn.leetcode._0213;

/**
 * <h6>打家劫舍 II</h6>
 *
 * <p>你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * <br/>这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * <br/>同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <br/>给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。</p>
 * <pre><b>Examples: </b>
 * <b>Example1: </b>
 * Input: [2,3,2]
 * Output: 3
 * Explanation: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * <b>Example2: </b>
 * Input: [1,2,3,1]]
 * Output: 4
 * Explanation: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * </pre>
 */
public class LeetCode213 {

    /**
     * <h6>动态规划法</h6>
     * 
     * <p><b>解题思路：</b>
     * <br/>解题思路与<a href="LeetCode198"><b>LeetCode198</b></a>相似，在环形数组中需要考虑三种情况：</p>
     * <ol><li>如果打劫第一家，就不能打劫最后一家</li>
     * <li>如果打劫最后一家，就不能打劫第一家</li>
     * <li>如果既不打劫第一家，也不打劫最后一家，这种情况中又包含上述两种情况</li>
     * </ol>
     * @param  nums
     * @return int
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) { // 如果数组长度为1，就打劫第一家
            return nums[0];
        } else if (nums.length == 2) { // 如果数组长度为2，就打劫钱最多的那家
            return (nums[0] > nums[1]) ? nums[0] : nums[1];
        }

        // 如果打劫第一家，就不能打劫最后一家
        int res1 = robNum(nums, 0, nums.length - 2);
        // 如果打劫最后一家，就不能打劫第一家
        int res2 = robNum(nums, 1, nums.length - 1);

        return (res1 > res2) ? res1 : res2;
    }

    /**
     * <h6>数组长度大于等于3的时候，处理方式</h6>
     * 
     * <p>如果数组长度为3及以上,考虑打劫第i家的时候，要比较打劫第i-1家获取的钱和打劫第i家、第i-2家共同获取钱的多少</p>
     * @param  nums
     * @param  begin
     * @param  end
     * @return int
     */
    private int robNum(int[] nums, int begin, int end) {
        int[] dp = new int[nums.length];
        dp[begin] = nums[begin];
        dp[begin + 1] = (dp[begin] > nums[begin + 1]) ? dp[begin] : nums[begin + 1];
        for (int i = begin + 2; i <= end; i++) {
            dp[i] = (dp[i - 1] > nums[i] + dp[i - 2]) ? dp[i - 1] : nums[i] + dp[i - 2];
        }
        return dp[end];
    }
}
