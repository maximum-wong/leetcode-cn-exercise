package kstar.leetcode_cn.leetcode._0050;

public class Solution2 {

    /**
     * <h6>二分法（递归方式实现）</h6>
     * 
     * <p>当n>=0，ret=x^n；当n<0，ret=1/(x^n)。
     * <br/>然后使用二分法奇数偶数求解x^n，奇数，ret=half*half*x；偶数，ret=half*half</p>
     * @param  x
     * @param  n
     * @return
     */
    public double myPow(double x, int n) {
        long m = n;
        return (m >= 0) ? myPowHelper(x, m) : 1.0 / myPowHelper(x, -1 * m);
    }

    private double myPowHelper(double x, long m) {
        if (m == 0) {
            return 1.0;
        }
        double half = myPowHelper(x, m >> 1);
        return (m & 1) == 0 ? half * half : half * half * x;
    }
}
