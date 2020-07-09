package kstar.leetcode_cn.leetcode._0643;

/**
 * <h6>累加求和法</h6>
 */
public class Solution2 {

    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len];
        sum[0] = nums[0];
        int maxSum = nums[k];
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        
        for (int i = k; i < len; i++) {
            maxSum = Math.max(maxSum, sum[i] - sum[i - k]);
        }
        
        return maxSum * 1.0 / k;
    }
}
