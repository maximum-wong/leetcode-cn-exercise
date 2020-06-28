package kstar.leetcode_cn.leetcode._0209;

/**
 * <h6>双指针法</h6>
 */
public class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= s) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
