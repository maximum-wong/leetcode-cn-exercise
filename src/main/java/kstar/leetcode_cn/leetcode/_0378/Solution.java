package kstar.leetcode_cn.leetcode._0378;

/**
 * <h6>二分查找</h6>
 * <p>由每行、每列元素都是升序排序得，第k小的元素一定在左上侧，使用二分查找选定在(0,0)到(n-1, n-1)之间的mid值，在小于mid值区间内找到合适的结果</p>
 */
public class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * desc：判断在矩阵左上侧是否存在不大于mid的k个数字
     * @param matrix
     * @param mid
     * @param k
     * @param n
     * @return
     */
    private boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            // 如果该点的值不大于mid，继续向右进行操作
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else { // 如果该点的值大于mid，继续向上进行操作
                i--;
            }
        }
        return num >= k;
    }
}
