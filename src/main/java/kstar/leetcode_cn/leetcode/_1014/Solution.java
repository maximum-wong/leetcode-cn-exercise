package kstar.leetcode_cn.leetcode._1014;

/**
 * <h6>找规律法</h6>
 * <p>A[i] + A[j] + i - j 可以变换为A[i] + i + A[j] - j，又由于A[j] - j的值在区间上是固定的，
 * <br/>问题就变成了求区间[0, j-1]上，A[i] + i的最大值</p>
 */
public class Solution {

    public int maxScoreSightseeingPair(int[] A) {

        if (A == null) {
            return 0;
        }

        if (A.length < 2) {
            return A[0];
        }

        int res = 0;
        int max = A[0];
        for (int j = 1; j < A.length; j++) {
            res = Math.max(res, max + A[j] - j);
            // 求区间[0, j-1]之间A[i] + i的最大值
            max = Math.max(max, A[j] + j);
        }
        return res;
    }
}
