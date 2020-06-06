package kstar.leetcode;

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
        // 溢出处理
        if ((divisor == 0) || (dividend == 0X80000000 && divisor == -1)) {
            return 0X7FFFFFFF;
        }

        // 求返回结果的符号
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        // 求绝对值，为防止溢出使用long
        long dvd = fastAbs((long) dividend);
        long dvs = fastAbs((long) divisor);
        // 记录结果
        int result = 0;

        // 被除数大于除数
        while (dvd >= dvs) {
            // 记录除数
            long temp = dvs;
            // 记录商的大小
            long mul = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                mul <<= 1;
            }
            // 减去最接近dvd的dvs的指数倍的值（值为temp）
            dvd -= temp;
            // 修正结果
            result += mul;
        }
        return result * sign;
    }

    private long fastAbs(long value) {
        long temp = value >> 63;
        return value ^ temp - temp;
    }
}
