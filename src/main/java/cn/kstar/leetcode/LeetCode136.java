package cn.kstar.leetcode;

/**
 * <h6>只出现一次的数字</h6>
 *
 * <p>给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <br/>说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？</p>
 * <pre><b>Examples: </b>
 * Input: [2,2,1]; Output: 1
 * 
 * Input:  [4,1,2,1,2]; Output: 4
 * </pre>
 */
public class LeetCode136 {

	/**
	 * <h6>使用异或</h6>
	 * 
	 * <p>A^A=0, A^0=A, A^B^B=A</p>
	 * 
	 * @param array
	 * @return
	 */
	public int singleNumber(int[] array) {
		int ret = array[0];
		for (int i = 1, length = array.length; i < length; i++) {
			ret ^= array[i];
		}
		return ret;
	}
}
