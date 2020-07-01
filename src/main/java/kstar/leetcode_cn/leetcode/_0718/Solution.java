package kstar.leetcode_cn.leetcode._0718;

/**
 * <h6>动态规划法</h6>
 * <p>dp[i][j]表示A[i:]和B[j:]的最长共前缀，如果A[i]==B[j]，则dp[i][j]=dp[i+1][j+1]+1；否则，dp[i][j]=0</p>
 */
public class Solution {

    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
