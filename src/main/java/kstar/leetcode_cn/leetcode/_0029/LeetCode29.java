package kstar.leetcode_cn.leetcode._0029;

/**
 * <h6>两数相除</h6>
 *
 * <p>给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <br/><b>说明:</b>
 * <br/>被除数和除数均为 32 位有符号整数。除数不为 0。
 * <br/>假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31, 2^31−1]。本题中，如果除法结果溢出，则返回 2^31−1。
 * </p>
 * <pre><b>Examples: </b>
 * Input: dividend = 10, divisor = 3; Output: 3
 * 
 * Input: dividend = 7, divisor = -3; Output: -2
 * </pre>
 */
public class LeetCode29 {

    /**
     * <h6>时间复杂度：O(log(n))</h6>
     * <p><b>解题思路：</b>
     * <br/>&nbsp;&nbsp;任何一个整数可以表示成以2的幂为底的一组基的线性组合,就是把十进制转二进制的过程。
     * <br/>&nbsp;&nbsp;左移一位相当于乘以2,右移一位相当于除以2.（这里不考虑溢出）
     * <br/>&nbsp;&nbsp;先让除数一直左移，直到大于被除数之前得到一个最大的基数。
     * <br/>&nbsp;&nbsp;然后接下来我们每次尝试减去这个基，如果可以则结果增加2^k,然后基继续右移迭代，直到基为0为止。
     * </p>
     *
     * @param  dividend
     * @param  divisor
     * @return int
     */
    public int divide(int dividend, int divisor) {
        // 符号位判定，sign为true代表结果为负，反之为正
        boolean sign = (dividend > 0) ^ (divisor > 0);
        // 将被除数与除数均转化为非正数，方便边界情况的处理
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;
        // 申请结果变量
        int result = 0;

        // 循环求解，注意此时 dividend <= 0, divisor < 0
        while (dividend <= divisor) {
            int tmp = -1;
            int flag = divisor;
            if (flag > (Integer.MIN_VALUE >> 1)) {
                while (dividend <= (flag << 1)) {
                    if (flag <= (Integer.MIN_VALUE >> 1)) break;
                    tmp <<= 1;
                    flag <<= 1;
                }
            }
            dividend -= flag;
            result += tmp;
        }

        // 结合符号位判断是否溢出
        return sign ? result : (result == Integer.MIN_VALUE ? Integer.MAX_VALUE : -result);
    }

}