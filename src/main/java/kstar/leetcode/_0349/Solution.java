package kstar.leetcode._0349;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        HashSet<Integer> set1 = new HashSet<>(nums1.length);
        for (int num : nums1) {
            set1.add(num);
        }

        HashSet<Integer> set2 = new HashSet<>(nums1.length);
        for (int num : nums2) {
            set2.add(num);
        }

        HashSet<Integer> smallSet = set1.size() < set2.size() ? set1 : set2;
        HashSet<Integer> bigSet = set1.size() >= set2.size() ? set1 : set2;

        return getIntersection(smallSet, bigSet);
    }

    private int[] getIntersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int[] output = new int[set1.size()];
        int idx = 0;
        for (Integer i : set1) {
            if (set2.contains(i)) {
                output[idx++] = i;
            }
        }
        return Arrays.copyOf(output, idx);
    }
}
