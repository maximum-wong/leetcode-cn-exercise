package kstar.leetcode_cn.leetcode._0189;

/**
 * <h6>三次翻转法</h6>
 */
public class Solution {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
