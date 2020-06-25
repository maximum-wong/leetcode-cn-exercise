package kstar.leetcode_cn.leetcode._0220;

import java.util.TreeSet;

/**
 * <h6>二叉搜索树法</h6>
 *
 */
public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            // 查找比当前数字大的最近数字
            Integer num1 = set.ceiling(nums[i]);
            if (num1 != null && num1 <= nums[i] + t) {
                return true;
            }

            // 查找比当前数字小的最近数字
            Integer num2 = set.floor(nums[i]);
            if (num2 != null && nums[i] <= num2 + t) {
                return true;
            }

            set.add(nums[i]);

            // 如果树的大小超过了k，移除最早加入树的那个数
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }

        }
        return false;
    }
}
