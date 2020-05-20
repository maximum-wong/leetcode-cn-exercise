package cn.kstar.leetcode.leetcode37;

public class Solution {

    // 存储当前行、列和宫的状态
    private boolean[][] rows = new boolean[9][10];
    private boolean[][] columns = new boolean[9][10];
    private boolean[][] boxes = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        // 初始化当前行、列和宫的状态
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] != '.') {
                    int num = board[row][column] - '0';
                    rows[row][num] = true;
                    columns[column][row] = true;
                    boxes[(row / 3) * 3 + column / 3][num] = true;
                }
            }
        }

        // 从board数组的左上角开始回溯
        backTrace(board, 0, 0);
    }

    private boolean backTrace(char[][] board, int row, int column) {
        // 回溯至右下角则返回结果
        if (row == 9) {
            return true;
        }

        // 若当前位置有数字，则移动到下一个位置
        if (board[row][column] != '.') {
            return backTrace(board, column == 8 ? row + 1 : row, column == 8 ? 0 : column + 1);
        } else {
            // 当前宫的索引
            int index = (row / 3) * 3 + column / 3;
            for (int i = 1; i < 10; i++) {
                // 当前情况下符合条件
                if (!rows[row][i] && !columns[column][i] && !boxes[index][i]) {
                    rows[row][i] = true;
                    columns[column][i] = true;
                    boxes[index][i] = true;
                    board[row][column] = (char) (i + '0');
                    // 后续情况符合条件
                    if (backTrace(board, column == 8 ? row + 1 : row, column == 8 ? 0 : column + 1)) {
                        return true;
                    }
                    // 否则状态回溯至本次操作之前
                    rows[row][i] = false;
                    columns[column][i] = false;
                    boxes[index][i] = false;
                    board[row][column] = '.';
                }
            }
        }
        return false;
    }
}
