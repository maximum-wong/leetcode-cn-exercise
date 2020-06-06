package kstar.leetcode;

/**
 * <h6>不同路径 II
 * <br/>Unique Paths II</h6>
 *
 * <p>一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <br/>A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).</p>
 * <p>机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <br/>The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).</p>
 * <p>现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <br/>Now consider if some obstacles are added to the grids. How many unique paths would there be?</p>
 * <img src="../../../pic/robot_maze.png"/>
 * <p>网格中的障碍物和空位置分别用 1 和 0 来表示。</p>
 * <p><b>提示：</b><i>m</i> 和 <i>n</i> 的值均不超过 100。
 * <br/><b>Note</b>: <i>m</i> and <i>n</i> will be at most 100.</p>
 * <b>Example1: </b>
 * <pre>
 * Input: 
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * 3x3 网格的正中间有一个障碍物。
 * There is one obstacle in the middle of the 3x3 grid above.
 *  从左上角到右下角一共有 2 条不同的路径：
 * There are two ways to reach the bottom-right corner:
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 1. Right -> Right -> Down -> Down
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 2. Down -> Down -> Right -> Right
 * </pre>
 */
public class LeetCode63 {

    /**
     * <h6>动态规划法</h6>
     * 
     * <p>思路跟<a href="LeetCode62">LeetCode62</a>相似，动态规划方程为：dp[n][m]=dp[n-1][m]+dp[n][m-1]</p>
     * @param  obstacleGrid
     * @return int
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = 1;

        // 处理第一行
        for (int i = 1; i < m; i++) {
            if (dp[0][i - 1] == 0) { // 之前位置有路障
                dp[0][i] = 0;
            } else if (obstacleGrid[0][i] == 1) { // 当前位置有路障
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }

        // 处理第一列
        for (int i = 1; i < n; i++) {
            if (dp[i - 1][0] == 0) { // 之前位置有路障
                dp[i][0] = 0;
            } else if (obstacleGrid[i][0] == 1) { // 当前位置有路障
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }

        // 统计结果
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
