package kstar.leetcode._0349;

import java.util.HashSet;
import java.util.Set;

/**
 * <h6>查表法</h6>
 */
public class Solution2 {

    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> parentSet = new HashSet<>(nums1.length);
        Set<Integer> childSet = new HashSet<>(nums2.length);

        for (int num : nums1) {
            parentSet.add(num);
        }

        for (int num : nums2) {
            if (parentSet.contains(num)) {
                childSet.add(num);
            }
        }

        int[] res = new int[childSet.size()];
        int idx = 0;
        for (int value : childSet) {
            res[idx++] = value;
        }
        return res;
    }
}
