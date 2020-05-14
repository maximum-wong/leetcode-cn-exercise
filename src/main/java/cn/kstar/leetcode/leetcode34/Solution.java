package cn.kstar.leetcode.leetcode34;

/**
 * <h6>二分法</h6>
 *
 */
public class Solution {

    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] ret = { -1, -1 };

        int left = getIndex(nums, target, true);

        if (left == nums.length || nums[left] != target) {
            return ret;
        }

        ret[0] = left;
        ret[1] = getIndex(nums, target, false) - 1;

        return ret;
    }

    private int getIndex(int[] nums, int target, boolean left) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target || (left && target == nums[mid])) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

}
