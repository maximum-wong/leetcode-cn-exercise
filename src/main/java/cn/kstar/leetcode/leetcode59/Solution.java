package cn.kstar.leetcode.leetcode59;

public class Solution {

    public int[][] generateMatrix(int n) {
        int leftX = 0;
        int rightX = n - 1;
        int topY = 0;
        int bottomY = n - 1;

        int num = 1;
        int[][] ret = new int[n][n];
        while (num <= n * n) {

            for (int i = leftX; i <= rightX; i++) {
                ret[topY][i] = num++;
            }
            topY++;
            for (int i = topY; i <= bottomY; i++) {
                ret[i][rightX] = num++;
            }
            rightX--;
            for (int i = rightX; i >= leftX; i--) {
                ret[bottomY][i] = num++;
            }
            bottomY--;
            for (int i = bottomY; i >= topY; i--) {
                ret[i][leftX] = num++;
            }
            leftX++;
        }
        return ret;
    }
}
