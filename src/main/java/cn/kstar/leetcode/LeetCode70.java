package cn.kstar.leetcode;

/**
 * <h6>爬楼梯</h6>
 * 
 * <p>假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <br/>每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <br/>注意：给定 n 是一个正整数。</p>
 * <pre><b>Examples: </b>
 * <b>Example 1: </b>
 * Input: 2; Output: 2;
 * Explanation: 有两种方法可以爬到楼顶。1.  1 阶 + 1 阶；2.  2 阶
 * 
 * <b>Example 2: </b>
 * Input: 3; Output: 3;
 * Explanation: 有三种方法可以爬到楼顶。1.  1 阶 + 1 阶 + 1 阶；2.  1 阶 + 2 阶；3.  2 阶 + 1 阶
 * </pre>
 */
public class LeetCode70 {

	/**
    * <h6>动态规划法</h6>
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

    /**
     * <h6>动态规划法（优化）</h6>
     * 
     * @param n
     * @return int
     */
    public int climbStairs2(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return n;
        }

        int ret = 0;
        // 保存上一个结果
        int pre = 2;
        // 保存上一个的上一个的结果
        int prePre = 1;
        for (int i = 3; i <= n; i++) {
            ret = pre + prePre;
            prePre = pre;
            pre = ret;
        }
        return ret;
    }

    /**
     * <h6>递归法（备忘录方式）</h6>
     * 
     * @param  n
     * @return int
     */
    public int climbStairs3(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return n;
        }

        // 使用一个数组保存已经计算过的值
        if (results == null) {
            results = new int[n + 1];
        }

        // 先从备忘录里面查找
        if (results[n] != 0) {
            return results[n];
        }

        // 查找不到再进行递归运算
        int ret = climbStairs2(n - 1) + climbStairs2(n - 2);
        // 保存递归运算的结果
        results[n] = ret;
        return ret;
    }

    private int[] results = null;

    /**
     * <h6>递归法</h6>
     * 
     * @param  n
     * @return int
     */
    public int climbStairs4(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return n;
        }

        return climbStairs3(n - 1) + climbStairs3(n - 2);
    }
}
