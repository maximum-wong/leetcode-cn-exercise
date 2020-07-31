package kstar.leetcode_cn.leetcode._0174;

import java.util.Arrays;

/**
 * <h6>（反向）动态规划法</h6>
 * <p>状态转移方程：dp[i][j]=max(min(dp[i+1][j], dp[i][j+1])-dungeon[i][j], 1)
 * <br/>边界条件：当i=n-1或者j=m-1时，dp[i][j]转移需要用到dp[i][j+1]和dp[i+1][j]中有无效值，因此代码实现中给无效值赋值为极大值。
 * 特别地，dp[n-1][m-1] 转移需要用到的 dp[n-1][m]和 dp[n][m-1]均为无效值，因此需要给这两个值赋值为 1。
 * <br/>最终答案为dp[0][0]</p>
 */
public class Solution {

    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        // 填充默认值
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], 0X7FFFFFFF);
        }
        // 处理dp[n-1][m-1]需要用到的特殊值
        dp[n][m - 1] = dp[n - 1][m] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
    
}
