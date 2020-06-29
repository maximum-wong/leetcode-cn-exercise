package kstar.leetcode_cn.leetcode._0165;

public class Solution {

    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length;
        int n2 = nums2.length;

        int idx1 = 0;
        int idx2 = 0;
        int idx = Math.max(n1, n2) - 1;
        for (int i = 0; i <= idx; i++) {
            idx1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            idx2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if (idx1 != idx2) {
                return idx1 > idx2 ? 1 : -1;
            }
        }
        return 0;
    }
}
