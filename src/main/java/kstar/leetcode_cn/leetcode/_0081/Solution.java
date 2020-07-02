package kstar.leetcode_cn.leetcode._0081;

/**
 * <h6>二分查找法</h6>
 */
public class Solution {

    public boolean search(int[] nums, int target) {
        
        if (nums == null || nums.length == 0) {
            return false;
        }

        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target || nums[left] == target) {
                return true;
            }
            if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[mid] > nums[left]) {
                if (nums[left] > target || nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] > target || nums[left] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
