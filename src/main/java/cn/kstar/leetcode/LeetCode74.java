package cn.kstar.leetcode;

/**
 * <h6>搜索二维矩阵</h6>
 *
 * <p>编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。
 * <br/>该矩阵具有如下特性：每行中的整数从左到右按升序排列。
 * <br/>每行的第一个整数大于前一行的最后一个整数。</p>
 * <pre><b>Examples: </b>
 * Input:
 * matrix = [
 * 	[1,   3,  5,  7],
 * 	[10, 11, 16, 20],
 * 	[23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * 
 * matrix = [
 * 	[1,   3,  5,  7],
 * 	[10, 11, 16, 20],
 * 	[23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 * </pre>
 */
public class LeetCode74 {

	/**
	 * <h6>二分查找法</h6>
	 * 
	 * <p>先竖着进行二分查找，如果目标值比当前行的首个值要大并且比当前行的最后一个值要小，
	 * <br/>就在当前行继续横着进行二分查找，直到找到是否存在目标值为止</p>
	 * @param  matrix
	 * @param  target
	 * @return boolean
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return false;
		}

		// 上指针
		int top = 0;
		// 下指针
		int bottom = matrix.length - 1;
		// 每行的最大下标值
		int col = matrix[0].length - 1;
		while (top <= bottom) {
			int mid = (top + bottom) / 2;
			// 目标值大于当前行的第一个值且小于最后一个值
			if (target >= matrix[mid][0] && target <= matrix[mid][col]) {
				searchRow(matrix[mid], target);
			}
			if (target > matrix[mid][col]) {
				top = mid + 1;
			}
			if (target < matrix[mid][0]) {
				bottom = mid - 1;
			}
		}
		return false;
	}

	/**
	 * <h6>对目标行进行二分查找</h6>
	 * @param  nums
	 * @param  target
	 * @return boolean
	 */
	private boolean searchRow(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}
}
