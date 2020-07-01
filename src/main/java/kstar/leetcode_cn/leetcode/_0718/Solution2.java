package kstar.leetcode_cn.leetcode._0718;

/**
 * <h6>滑动窗口法</h6>
 */
public class Solution2 {

    public int findLength(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;
        int ret = 0;

        // 固定数组B，数组A向后滑动
        for (int i = 0; i < len1; i++) {
            int maxLen = maxLength(A, B, i, 0, Math.min(len1 - i, len2));
            ret = Math.max(ret, maxLen);
        }

        // 固定数组A，数组B向后滑动
        for (int i = 0; i < len2; i++) {
            int maxLen = maxLength(A, B, 0, i, Math.min(len1, len2 - i));
            ret = Math.max(ret, maxLen);
        }

        return ret;
    }

    private int maxLength(int[] A, int[] B, int offsetA, int offsetB, int len) {
        int ret = 0;
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (A[offsetA + i] == B[offsetB + i]) {
                idx++;
            } else {
                idx = 0;
            }
            ret = Math.max(ret, idx);
        }
        return ret;
    }
}
