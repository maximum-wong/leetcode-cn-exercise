package kstar.leetcode._0221;

public class Solution {

    /**
     * <h6>动态规划法</h6>
     * 
     * <p>时间复杂度：O(m*n)；空间复杂度：O(m*n)</p>
     * <p>正方形边长的动态方程：dp[i][j]=min(min(i-1,j),min(i,j-1),min(i-1,j-1))+1</p>
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int y = matrix.length;
        int x = matrix[0].length;
        int[][] dp = new int[y][x];
        int maxEdge = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) { // 处理最上边和最左边的的情况
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
                maxEdge = Math.max(maxEdge, dp[i][j]);
            }
        }
        return maxEdge * maxEdge;
    }
}
