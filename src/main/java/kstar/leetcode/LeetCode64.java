package kstar.leetcode;

/**
 * <h6>最小路径和
 * <br/>Minimum Path Sum</h6>
 *
 * <p>给定一个包含非负整数的 <em>m x n</em> 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <br/>Given a <em>m x n</em> grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.</p>
 * <p><b>说明：</b>每次只能向下或者向右移动一步。
 * <b>Note: </b>You can only move either down or right at any point in time.</p>
 * <p><b>示例:</b>
 * <br/><b>Example:</b></p>
 * <pre>
 * <b>输入:</b>
 * <b>Input:</b>
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * <b>输出:</b> 7
 * <b>Output:</b> 7
 * <b>解释:</b> 因为路径 1→3→1→1→1 的总和最小。
 * <b>Explanation:</b> Because the path 1→3→1→1→1 minimizes the sum.
 * </pre>
 */
public class LeetCode64 {

    /**
     * <h6>动态规划</h6>
     *
     * <p>使用动态规划法，动态转移方程为：dp[i][j]=min(dp[i-1][j], dp[i][j-1])+grid[i][j]</p>
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) { // 处理第0行的情况
                    if (j == 0) { // 处理第0列的情况
                        dp[i][j] = grid[i][j];
                    } else {
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    }
                } else if (j == 0) { // 处理第0列的情况
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    int min = dp[i - 1][j] > dp[i][j - 1] ? dp[i][j - 1] : dp[i - 1][j];
                    dp[i][j] = min + grid[i][j];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
