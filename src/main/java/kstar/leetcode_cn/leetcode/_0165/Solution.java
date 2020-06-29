package kstar.leetcode_cn.leetcode._0165;

/**
 * <h6>拆分，分段比较法</h6>
 */
public class Solution {

    public int compareVersion(String version1, String version2) {
        // 拆分版本号为好几段
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length;
        int n2 = nums2.length;

        // 比较每段的数值
        int value1 = 0;
        int value2 = 0;
        int idx = Math.max(n1, n2) - 1;
        for (int i = 0; i <= idx; i++) {
            value1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            value2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if (value1 != value2) {
                return value1 > value2 ? 1 : -1;
            }
        }
        return 0;
    }
}
