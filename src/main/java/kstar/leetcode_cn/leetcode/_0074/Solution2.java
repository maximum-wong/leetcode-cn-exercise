package kstar.leetcode_cn.leetcode._0074;

/**
 * <h6>一次二分查找法</h6>
 * <p>坐标映射关系：mid = (mid/col, mid%col)</p>
 */
public class Solution2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;
        int left = 0;
        int right = row * column - 1;
        int mid = 0;
        int midVal = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            midVal = matrix[mid / column][mid % column];
            if (target == midVal) {
                return true;
            } else if (target < midVal) {
                right = mid - 1;
            } else {
                right = mid + 1;
            }
        }

        return false;
    }

}
