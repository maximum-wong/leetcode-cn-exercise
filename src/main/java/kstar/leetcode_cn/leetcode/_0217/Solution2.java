package kstar.leetcode_cn.leetcode._0217;

import java.util.Arrays;

/**
 * <h6>排序+查找相邻元素法</h6>
 */
public class Solution2 {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }
}
