package cn.kstar.leetcode;

/**
 * <h6>最大子序和
 * <br/>Maximum Subarray</h6>
 *
 * <p>给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <br/>Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.</p>
 * <pre><b>Examples: </b>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * [4,-1,2,1] has the largest sum = 6.
 * </pre>
 * <p>进阶:
 * <br/>Follow up:</p>
 * <p>如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <br/>If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach, which is more subtle.</p>
 */
public class LeetCode53 {

    /**
     * <h6>动态规划法</h6>
     * 
     * <ul><li><b>问题拆解：</b>
     * <br/>子数组可以看做一段区间，先确定子数组在i截止的这个位置，问题转换为以i结尾的所有子数组中，和最大的是多少？
     * 继续拆解，i这个位置的元素自成一个子数组，结果就变成为i位置元素的值与以i-1结尾的子数组和最大值</li>
     * <li><b>状态定义：</b>
     * <br/>dp[i]就是以i结尾的所有子数组的最大值</li>
     * <li><b>递推方程：</b>
     * <br/>根据拆解结果，状态方程为：dp[i] = max(dp[i-1] + array[i], array[i])，
     * 简化为：dp[i] = max(dp[i-1], 0) + array[i]</li>
     * <li><b>递实现：</b>
     * <br/>题目要求子数组不能为空，因此开始就要初始化，即dp[0]=array[0]，另外需要一个变量记录最后的答案</li></ul>
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < length; i++) {
            dp[i] = (dp[i - 1] > 0 ? dp[i - 1] : 0) + nums[i];
            result = (result > dp[i]) ? result : dp[i];
        }

        return result;
    }
}
