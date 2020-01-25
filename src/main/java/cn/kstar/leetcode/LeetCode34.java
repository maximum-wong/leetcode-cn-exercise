package cn.kstar.leetcode;

/**
 * <h6>在排序数组中查找元素的第一个和最后一个位置</h6>
 * 
 * <p>给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <br/>你的算法时间复杂度必须是 O(log n) 级别。如果数组中不存在目标值，返回 [-1, -1]。</p>
 * <pre><b>Explanation:</b>
 * Input: nums = [5,7,7,8,8,10], target = 8; Output: [3,4]
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6; Output: [-1,-1]
 * </pre>
 */
public class LeetCode34 {

	/**
	 * <h6>二分查找法</h6>
	 * 
	 * <p>使用二分查找法，以searchBegin为例，当nums[mid]>target时，向左查找，当nums[mid]=targe时，向左查找。
	 * <br/>这样所有情况下，范围都会缩小，直到l==r为止，这时如果该位置里的数==target，则返回该位置，否则返回-1。
	 * <br/>searchEnd同理。</p>
	 * 
	 * @param  array
	 * @param  target
	 * @return int[]
	 */
	public int[] searchRange(int[] array, int target) {
		int[] ret = { -1, -1 };
		if (array == null || array.length == 0) {
			return ret;
		}
		int left = 0;
		int right = array.length;
		int mid = (left + right) / 2;
		int position = -1;
		while (left < right) {
			if (array[mid] == target) {
				position = mid;
				break;
			}
			if (array[mid] > target) {
				if (right == mid) {
					break;
				}
				right = mid;
				mid = (left + right) / 2;
			} else {
				if (left == mid) {
					break;
				}
				left = mid;
				mid = (left + right) / 2;
			}
		}
		if (position == -1) {
			return ret;
		} else {
			int a = position;
			int b = position;
			while (a > 0 && array[a - 1] == target) {
				a--;
			}
			while (b < array.length - 1 && array[b + 1] == target) {
				b++;
			}
			return new int[] { a, b };
		}
	}
}
