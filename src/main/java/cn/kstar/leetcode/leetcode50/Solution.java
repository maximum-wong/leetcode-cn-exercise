package cn.kstar.leetcode.leetcode50;

public class Solution {

    /**
     * <h6>二分法（循环方式实现）</h6>
     * 
     * <p>当n>=0，ret=x^n；当n<0，ret=1/(x^n)。
     * <br/>然后使用二分法奇数偶数求解x^n，奇数，ret=half*half*x；偶数，ret=half*half</p>
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long m = n;
        return (m >= 0) ? myPowHelper(x, m) : 1.0 / myPowHelper(x, -1 * m);
    }

    private double myPowHelper(double x, long m) {
        double res = 1;
        while (m > 0) {
            if ((m & 1) == 1) {
                res *= x;
            }
            x *= x;
            m >>= 2;
        }
        return res;
    }

}
