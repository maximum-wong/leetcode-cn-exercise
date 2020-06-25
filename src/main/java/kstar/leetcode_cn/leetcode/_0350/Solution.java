package kstar.leetcode_cn.leetcode._0350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <h6>查表法</h6>
 */
public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        // 寻找较小的和较大的数组
        int[] littleNums = (nums1.length < nums2.length) ? nums1 : nums2;
        int[] bigNums = (nums1.length >= nums2.length) ? nums1 : nums2;

        // 把较小数组中的元素放入哈希表中并统计出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : littleNums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 记录相同元素的个数
        int idx = 0;
        // 遍历较大的数组，取哈希表中出现的元素，放入较小数组中
        for (int num : bigNums) {
            int count = map.getOrDefault(num, 0);
            // 出现1次及以上的元素才能放入到较小数组中
            if (count > 0) {
                littleNums[idx++] = num;
                // 更改哈希表中元素出现的次数
                map.put(num, count - 1);
            }
        }

        return Arrays.copyOf(littleNums, idx);
    }
}
