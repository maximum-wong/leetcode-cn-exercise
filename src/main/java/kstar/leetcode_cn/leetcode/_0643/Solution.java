package kstar.leetcode_cn.leetcode._0643;

/**
 * <h6>滑动窗口法</h6>
 */
public class Solution {

    public double findMaxAverage(int[] nums, int k) {

        double sum = 0;

        // 初始化一个窗口的和
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // 寻找窗口最大的和
        for (int i = k; i < nums.length; i++) {
            sum = Math.max(sum, sum - nums[i - k] + nums[i]);
        }

        // 求最大平均值
        return sum / k;
    }
}
