package kstar.leetcode_cn.leetcode._0407;

import java.util.PriorityQueue;

public class Solution {

    public int trapRainWater(int[][] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int n = heights.length;
        int m = heights[0].length;
        // 标记这个位置是否被访问过
        boolean[][] visited = new boolean[n][m];
        // 优先队列存放三元数组的[x, y, heigh]坐标和高度
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[2] - y[2]);

        // 先把最外一圈放进去
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    queue.offer(new int[]{i, j, heights[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        int res = 0;
        // 方向数组，把dx和dy压缩成一维来做
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            // 看一下周围四个方向，没访问过的话能不能往里面灌水
            for (int k = 0; k < 4; k++) {
                int nx = poll[0] + dirs[k];
                int ny = poll[1] + dirs[k + 1];
                // 如果位置合法且未访问过
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    // 如果外围这一圈中最小的比当前这个还高，则能往里面灌水
                    if (poll[2] > heights[nx][ny]) {
                        res += poll[2] - heights[nx][ny];
                    }
                    // 如果灌水高度得是你灌水后的高度了，如果没灌水也要取高的
                    queue.offer(new int[]{nx, ny, Math.max(heights[nx][ny], poll[2])});
                    visited[nx][ny] = true;
                }
            }
        }
        return res;
    }
}
