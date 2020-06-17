package kstar.leetcode._0665;

/**
 * <h6>线性扫描法</h6>
 */
public class Solution {

    public boolean checkPossibility(int[] nums) {

        if (nums == null) {
            return false;
        }

        if (nums.length < 3) {
            return true;
        }

        // 统计需要更改个数
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) {
                    return false;
                }
                if (i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];
                }
            }
        }

        return true;
    }
}
