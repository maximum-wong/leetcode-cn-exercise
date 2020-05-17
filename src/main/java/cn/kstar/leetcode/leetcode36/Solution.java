package cn.kstar.leetcode.leetcode36;

public class Solution {

    public boolean isValidSudoku(char[][] board) {

        // 行数组
        boolean[][] rows = new boolean[9][9];
        // 列数组
        boolean[][] columns = new boolean[9][9];
        // 宫数组
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    // 获取宫数组的坐标
                    int k = (i / 3) * 3 + j / 3;
                    // 判断对应数组里面的num是否存在
                    if (rows[i][num] || columns[j][num] || boxes[k][num]) {
                        return false;
                    }
                    rows[i][num] = true;
                    columns[j][num] = true;
                    boxes[k][num] = true;
                }
            }
        }

        return true;
    }
}
