package cn.kstar.leetcode;

/**
 * <h6>不同路径
 * <br/>Unique Paths</h6>
 *
 * <p>一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <br/>A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).</p>
 * <p>机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <br/>The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).</p>
 * <p>问总共有多少条不同的路径？
 * <br/>How many possible unique paths are there?</p>
 * <img src="../../../pic/robot_maze.png"/>
 * <p>例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <br/>Above is a 7 x 3 grid. How many possible unique paths are there?</p>
 * <p><b>提示：</b>m 和 n 的值均不超过 100。
 * <br/><b>Note</b>: m and n will be at most 100.</p>
 * <pre><b>Examples: </b>
 * <b>Example1: </b>
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: 从左上角开始，总共有 3 条路径可以到达右下角。
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. 向右 -> 向右 -> 向下
 * 1. Right -> Right -> Down
 * 2. 向右 -> 向下 -> 向右
 * 2. Right -> Down -> Right
 * 3. 向下 -> 向右 -> 向右
 * 3. Down -> Right -> Right
 *
 * <b>Example2: </b>
 * Input: m = 7, n = 3
 * Output: 28
 * </pre>
 */
public class LeetCode62 {

    /**
     * <h6>动态规划法</h6>
     * 
     * <p>机器人走到(n,m)的位置，上一步可能从(n-1, m)或者(n, m-1)位置上过来的。
     * <br/>动态规划方程为：dp[n][m]=dp[n-1][m]+dp[n][m-1]</p>
     * @param  m
     * @param  n
     * @return int
     */
    public int uniquePaths(int m, int n) {

        // 初始化动态规划数组为:(n+1)*(m+1)，让当n=0或m=0时有只=值
        int[][] dp = new int[n + 1][m + 1];

        // 初始化第一行
        for (int i = 1; i <= m; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[n][m];
    }
}
