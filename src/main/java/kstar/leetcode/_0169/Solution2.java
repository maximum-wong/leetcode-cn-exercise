package kstar.leetcode._0169;

import java.util.Arrays;

/**
 * <h6>排序法</h6>
 * <p>因为超过半数数字一定会在排序好的数组中间出现</p>
 */
public class Solution2 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length>>1];
    }
}
