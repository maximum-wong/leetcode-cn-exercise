package cn.kstar.leetcode;

/**
 * <h6>分发糖果</h6>
 *
 * <p>老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <br/>你需要按照以下要求，帮助老师给这些孩子分发糖果：每个孩子至少分配到 1 个糖果。
 * <br/>相邻的孩子中，评分高的孩子必须获得更多的糖果。那么这样下来，老师至少需要准备多少颗糖果呢？</p>
 * <pre><b>Examples: </b>
 * Input: head = [1,0,2]; Output: 5
 * Explanation: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 
 * Input: head = [1,2,2]; Output: 4
 * Explanation: 你可以分别给这三个孩子分发 1、2、1 颗糖果。第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * </pre>
 */
public class LeetCode135 {

	/**
	 * <p><b>解题思路：</b>
	 * <ol><li>首先保证每个孩子都至少能分配到一个糖果</li>
	 * <li>从左到右遍历，考虑到右边的孩子比左边的评分更高，此时右边的糖果数比左边的多一个</li>
	 * <li>从右到左遍历，考虑到左边的孩子比右边的评分更高，但又要考虑到不破坏第二条已满足的规则，
	 * <br/>此时比较右边的糖果数加一的值和左边的糖果数，取其较大值。</li>
	 * </ol></p>
	 * 
	 * @param  ratings
	 * @return int
	 */
	public int candy(int[] ratings) {
		int ret = 0;
		if (ratings == null || ratings.length == 0) {
			return ret;
		}

		int[] resCandy = new int[ratings.length];
		// 给每个孩子分配一个糖果
		for (int i = 0, length = ratings.length; i < length; i++) {
			resCandy[i] = 1;
		}

		// 给比左边评分更高的孩子分配糖果
		for (int i = 0, length = ratings.length - 1; i < length; i++) {
			if (ratings[i + 1] > ratings[i]) {
				resCandy[i + 1] = resCandy[i] + 1;
			}
		}

		// 给比右边评分更高的孩子分配糖果
		for (int i = ratings.length - 1; i >= 1; i--) {
			if (ratings[i - 1] > ratings[i]) {
				// 不能破坏当前元素比左边孩子高的规则
				int tmp = resCandy[i] + 1;
				resCandy[i - 1] = (tmp > resCandy[i - 1]) ? tmp : resCandy[i - 1];
			}
		}

		// 将分配结果求和累加
		for (int i = 0, length = ratings.length; i < length; i++) {
			ret += resCandy[i];
		}

		return ret;
	}
}
