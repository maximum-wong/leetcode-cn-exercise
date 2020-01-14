package cn.kstar.leetcode;

/**
 * <h3>整数反转</h3>
 *
 * <p>给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。</p>
 * 
 * <p>
 * <strong>Example 1: </strong><br/>
 * Input: 123<br/>
 * Output: 321
 * </p>
 * 
 * <p>
 * <strong>Example 2: </strong><br/>
 * Input: -123<br/>
 * Output: -321
 * </p>
 * 
 * <p>
 * <strong>Example 3: </strong><br/>
 * Input: -123<br/>
 * Output: -321
 * </p>
 * 
 */
public class LeetCode7 {

	/**
	 * 解题思路
	 * 
	 * |-------------------------------------------------|
	 * | 数字 | 最低位     | 结果             | 剩余数字 |
	 * |-------------------------------------------------|
	 * | -123 | -123%10=-3 | 0*10+(-3)=-3     | -12      |
	 * | -12  | -12%10=-2  | -3*10+(-2)=-32   | -1       |
	 * | -1   | -1%10=-1   | -32*10+(-1)=-321 | 0        |
	 * |-------------------------------------------------|
	 * 
	 * @param  x
	 * @return int
	 */
	public int reverse(int x) {
		// 使用long类型来接收结果，防止反转后int类型溢出
		long res = 0;

		while (x != 0) {
			// 获取最低位及中间结果
			res = res * 10 + x % 10;
			// 在原先数字上移除最低位
			x /= 10;
			// 判断是否溢出
			if (res > 0X7FFFFFFF || res < 0X80000000) {
				return 0;
			}
		}
		return (int) res;
	}
	
	/**
	 * 判断溢出的另一种方法
	 * 
	 * @param x
	 * @return int
	 */
	public int reverse2(int x) {
		int res = 0;
		int tenthMaxValue = 0X7FFFFFFF / 10;
		int tenthMinValue = 0X80000000 / 10;
		while (x != 0) {
			int pop = x % 10;
			if ((res > tenthMaxValue) || (res == tenthMaxValue && pop > 7)) {
				return 0;
			}
			if ((res < tenthMinValue) || (res == tenthMinValue && pop < -8)) {
				return 0;
			}
			res = res * 10 + pop;
			x /= 10;
		}
		return res;
	}
}
