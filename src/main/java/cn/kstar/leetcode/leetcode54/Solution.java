package cn.kstar.leetcode.leetcode54;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int yStart = 0;
        int yEnd = matrix.length - 1;
        int xStart = 0;
        int xEnd = matrix[0].length - 1;

        while ((yStart <= yEnd) && (xStart <= xEnd)) {
            // 从左往右，从上从下遍历
            for (int x = xStart; x <= xEnd; x++) {
                result.add(matrix[yStart][x]);
            }
            for (int y = yStart + 1; y <= yEnd; y++) {
                result.add(matrix[y][xEnd]);
            }
            // 从右到左，从下往上遍历
            if (yStart < yEnd && xStart < xEnd) {
                for (int x = xEnd - 1; x > xStart; x--) {
                    result.add(matrix[yEnd][x]);
                }
                for (int y = yEnd; y > yStart; y--) {
                    result.add(matrix[y][xStart]);
                }
            }
            // 遍历一圈后，调整边界
            yStart++;
            yEnd--;
            xStart++;
            xEnd--;
        }

        return result;
    }

}
