package cn.kstar.leetcode;

/**
 * <h6>爬楼梯</h6>
 * 
 * <p>假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <br/>每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <br/>注意：给定 n 是一个正整数。</p>
 * <pre><b>Examples: </b>
 * Input: 2; Output: 2;
 * Explanation: 有两种方法可以爬到楼顶。1.  1 阶 + 1 阶；2.  2 阶
 * 
 * Input: 3; Output: 3;
 * Explanation: 有三种方法可以爬到楼顶。1.  1 阶 + 1 阶 + 1 阶；2.  1 阶 + 2 阶；3.  2 阶 + 1 阶
 * </pre>
 */
public class LeetCode70 {

	/**
    * <h6>状态规划法</h6>
    * 
    * <p>使用DP法，状态方程为：dp[i]=dp[i-1]+dp[i-2]。
    * </br/>i-1的时候跳一步可以到达i；i-2的时候跳一步是i-1，这个变成dp[i-1]的子问题了,直接跳两步可以到达i</p>
    * @param  n
    * @return int
    */
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
