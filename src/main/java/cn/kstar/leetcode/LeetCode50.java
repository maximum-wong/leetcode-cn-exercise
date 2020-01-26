package cn.kstar.leetcode;

/**
 * <h6>求x的n次方</h6>
 * <p>实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <br/>-100.0 < x < 100.0, n 是 32 位有符号整数，其数值范围是 [−2^31, 231^−1] 。</p>
 * <pre><b>Examples:</b>
 * Input: 2.00000, 10; Output: 1024.00000
 * 
 * Input: 2.10000, 3; Output: 9.26100
 * 
 * Input: 2.00000, -2; Output: 0.25000
 * Explanation: 2^-2=1/(2^2)=1/4=0.25
 * </pre>
 */
public class LeetCode50 {

	/**
	 * <h6>二分法（递归方式实现）</h6>
	 * 
	 * <p>当n>=0，ret=x^n；当n<0，ret=1/(x^n)。
	 * <br/>然后使用二分法奇数偶数求解x^n，奇数，ret=half*half*x；偶数，ret=half*half</p>
	 * 
	 * @param  x
	 * @param  n
	 * @return double
	 */
	public double recursivePow(double x, int n) {
		if (n >= 0) {
			return powHelper(x, n);
		} else {
			return 1 / powHelper(x, n);
		}
	}

	private double powHelper(double x, int n) {
		if (n == 0) {
			return 1;
		}
		double half = powHelper(x, n / 2);
		if ((n & 1) == 0) {
			return half * half;
		} else {
			return half * half * x;
		}
	}
}
