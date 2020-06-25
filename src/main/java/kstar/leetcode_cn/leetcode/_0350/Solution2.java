package kstar.leetcode_cn.leetcode._0350;

import java.util.Arrays;

/**
 * <h6>排序+双指针法</h6>
 */
public class Solution2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        // 寻找较小的和较大的数组
        int[] littleNums = (nums1.length < nums2.length) ? nums1 : nums2;
        int[] bigNums = (nums1.length >= nums2.length) ? nums1 : nums2;
        
        // 排序
        Arrays.sort(littleNums);
        Arrays.sort(bigNums);
        
        int idx1 = 0;
        int idx2 = 0;
        int idx = 0;
        
        // 同时边离较小的和较大的数组，寻找到相同元素，放入到较小元素中
        while (idx1 < littleNums.length && idx2 < bigNums.length) {
            if (littleNums[idx1] > bigNums[idx2]) {
                idx2++;
            } else if (littleNums[idx1] < bigNums[idx2]) {
                idx1++;
            } else if (littleNums[idx1] == bigNums[idx2]) {
                littleNums[idx] = littleNums[idx1];
                idx++;
                idx1++;
                idx2++;
            }
        }

        return Arrays.copyOf(littleNums, idx);
    }
}
