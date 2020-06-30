package kstar.leetcode_cn.leetcode._0073;

public class Solution {

    public void setZeroes(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        boolean rowFlag = false;
        boolean columnFlag = false;

        // 选定第一行、第一列位标志行、标志列
        // 判断第一列是否要全部置为0
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                columnFlag = true;
            }
        }

        // 判断第一行是否要全部置为0
        for (int j = 0; j < column; j++) {
            if (matrix[0][j] == 0) {
                rowFlag = true;
            }
        }

        // 更新每行和每列的第一个数字
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 更新除第一行、第一列之外的整个矩阵
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 判断第一行是否需要更新，若是，则需要更新
        if (rowFlag) {
            for (int j = 0; j < column; j++) {
                matrix[0][j] = 0;
            }
        }

        // 判断第一列是否需要更新，若是，则需要更新
        if (columnFlag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
