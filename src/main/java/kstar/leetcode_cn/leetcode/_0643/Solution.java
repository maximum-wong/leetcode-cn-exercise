package kstar.leetcode_cn.leetcode._0643;

/**
 * <h6>滑动窗口法</h6>
 */
public class Solution {

    public double findMaxAverage(int[] nums, int k) {

        double slidingWindow = 0;

        // 初始化一个窗口的和
        for (int i = 0; i < k; i++) {
            slidingWindow += nums[i];
        }

        double maxValue = slidingWindow;

        // 寻找窗口最大的和
        for (int i = k; i < nums.length; i++) {
            slidingWindow = slidingWindow - nums[i - k] + nums[i];
            maxValue = Math.max(maxValue, slidingWindow);
        }

        // 求最大平均值
        return maxValue / k;
    }
}
