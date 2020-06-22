package kstar.leetcode._0217;

import java.util.HashSet;
import java.util.Set;

/**
 * <h6>查表法</h6>
 */
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }

        return false;
    }
}
