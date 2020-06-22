package kstar.leetcode._0219;

import java.util.HashMap;
import java.util.Map;

/**
 * <h6>查表法</h6>
 */
public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        // 使用HashMap存储元素及其对应的下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 获取当前元素的下标
            Integer idx = map.get(nums[i]);
            // HashMap中不存在的元素放在HashMap中
            if (idx == null) {
                map.put(nums[i], i);
            } else {
                // 比较新旧下标差的绝对值是否不超过k
                if (Math.abs(idx - i) <= k) {
                    return true;
                } else {
                    // 更新当前元素的下标
                    map.put(nums[i], i);
                }
            }
        }

        return false;
    }
}
