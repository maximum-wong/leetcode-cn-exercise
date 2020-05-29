package cn.kstar.leetcode.leetcode48;

/**
 * 变换关系：
 * <pre>
 * [n - 1 - j, i]<--[n - 1 - i, n -1 -j]<--[j, n - 1 -i]<--[i, j]
 *      |                                                     ^
 *      |_____________________________________________________|
 * </pre>
 */
public class Solution {

    public void rotate(int[][] matrix) {

        if (matrix == null || matrix.length < 2) {
            return;
        }

        int n = matrix.length;

        for (int i = 0; i < ((n + 1) >> 1); i++) {
            for (int j = 0; j < (n >> 1); j++) {
                // 需要一个零时变量保存matrix[n - j - 1][i]，防止丢失
                int tmp = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
}
