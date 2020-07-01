package kstar.leetcode_cn.leetcode._0162;

/**
 * <h6>二分法</h6>
 */
public class Solution2 {

    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = left + ((right - left) >> 1);
        if (nums[mid] > nums[mid + 1]) {
            return search(nums, left, mid);
        }
        return search(nums, mid + 1, right);
    }
}
