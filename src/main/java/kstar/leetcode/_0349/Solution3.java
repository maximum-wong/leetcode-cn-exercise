package kstar.leetcode._0349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <h6>排序+双指针法</h6>
 */
public class Solution3 {

    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] == nums2[idx2]) {
                set.add(nums1[idx1]);
                idx1++;
                idx2++;
            } else if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else if (nums1[idx1] > nums2[idx2]) {
                idx2++;
            }
        }

        int[] res = new int[set.size()];
        int idx = 0;
        for (int i : set) {
            res[idx++] = i;
        }
        return res;
    }
}
