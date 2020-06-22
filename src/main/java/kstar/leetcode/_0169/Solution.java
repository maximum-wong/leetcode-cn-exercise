package kstar.leetcode._0169;

import java.util.HashMap;
import java.util.Map;

/**
 * <h6>查表法</h6>
 */
public class Solution {

    public int majorityElement(int[] nums) {
        // 使用HashMap统计每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int halfLen = nums.length >> 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > halfLen) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
