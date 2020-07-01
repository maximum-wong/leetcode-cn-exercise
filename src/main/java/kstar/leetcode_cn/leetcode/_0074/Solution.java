package kstar.leetcode_cn.leetcode._0074;

/**
 * <h6>两次二分查找法</h6>
 * <p>在搜索所在行的时候，以最后一列的值与target大小作为收缩边界的判断依据</p>
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        // 使用二分查找目标所在的行
        int top = 0;
        int bottom = row - 1;
        int mid = 0;
        while (top < bottom) {
            mid = top + ((bottom - top) >> 1);
            if (matrix[mid][column - 1] < target) {
                top = mid + 1;
            } else {
                bottom = mid;
            }
        }

        // 使用二分查找目标所在的列
        int left = 0;
        int right = column - 1;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (matrix[top][mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (matrix[top][left] == target) {
            return true;
        }

        return false;
    }

}
