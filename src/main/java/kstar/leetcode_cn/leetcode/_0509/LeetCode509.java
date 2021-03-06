package kstar.leetcode_cn.leetcode._0509;

/**
 * <h6>斐波那契数</h6>
 *
 * <p>斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，
 * <br/>后面的每一项数字都是前面两项数字的和。也就是：
 * <br/>The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * <br/>such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * <pre>
 * F(0) = 0, F(1) = 1 
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * </pre>给定 N，计算 F(N)。
 * <br/>Given N, calculate F(N).</p>
 * <pre><b>Examples:</b>
 * <b>Example 1: </b>
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 * <b>Example 2: </b>
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 * <b>Example 3: </b>
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * </pre>
 * <p>提示：0 ≤ N ≤ 30
 * <br/>Note: 0 ≤ N ≤ 30.</p>
 */
public class LeetCode509 {

    /**
     * <h6>递归法</h6>
     *
     * <p>时间复杂度：O(2^n)；空间复杂度：O(n)</p>
     * @param  n
     * @return int
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * <h6>递归法（备忘录方式）</h6>
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n <= 1) {
            return n;
        }

        if (results == null) {
            results = new int[n + 1];
        }

        if (results[n] != 0) {
            return results[n];
        }

        int ret = fib2(n - 1) + fib2(n - 2);
        results[n] = ret;
        return ret;
    }

    private int[] results = null;

    /**
     * <h6>循环法</h6>
     *
     * <p>时间复杂度：O(n)；空间复杂度：O(n)</p>
     * @param  n
     * @return int
     */
    public int fib3(int n) {
        if (n <= 1) {
            return n;
        }
        // 保存已经计算过的值
        int[] result = new int[n + 1];
        result[1] = 1;
        // 自底向上操作
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }

    /**
     * <h6>循环法（优化）</h6>
     * 
     * @param  n
     * @return int
     */
    public int fib4(int n) {
        if (n <= 1) {
            return n;
        }

        int ret = 0;
        int pre = 1;
        int prePre = 0;
        for (int i = 2; i <= n; i++) {
            ret = pre + prePre;
            prePre = pre;
            pre = ret;
        }
        return ret;
    }
}
