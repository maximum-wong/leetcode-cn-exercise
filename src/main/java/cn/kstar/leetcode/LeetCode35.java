package cn.kstar.leetcode;

/**
 * <h6>搜索插入位置</h6>
 * 
 * <p>给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * <br/>如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <br/>你可以假设数组中无重复元素。</p>
 * 
 * <pre><b>Examples:</b>
 * Input: [1,3,5,6], 5; Output: 2
 * Input: [1,3,5,6], 2; Output: 1
 * Input: [1,3,5,6], 7; Output: 4
 * Input: [1,3,5,6], 0; Output: 0
 * </pre>
 */
public class LeetCode35 {

	/**
	 * <h6>遍历搜索法</h6>
	 * 
	 * @param  array
	 * @param  target
	 * @return int
	 */
	public int searchInsertPostion1(int[] array, int target) {
		if (array == null) {
			return 0;
		}
		int i = 0;
		for (int length = array.length; i < length; i++) {
			if (array[i] >= target) {
				return i;
			}
		}
		return i;
	}
	
	/**
	 * <h6>二分查找法</h6>
	 * 
	 * @param  array
	 * @param  target
	 * @return int
	 */
	public int searchInsertPostion2(int[] array, int target) {
		if (array == null) {
			return 0;
		}
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
}
