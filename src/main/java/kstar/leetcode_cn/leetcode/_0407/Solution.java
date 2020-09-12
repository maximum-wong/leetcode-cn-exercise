package kstar.leetcode_cn.leetcode._0407;

import java.util.PriorityQueue;

/**
 * 把每一个元素称作块。因为那个图片给的好像瓷砖啊。
 * 其实做这题一开始都是想的是对于每一个块，去找它四个方向最高的高度中的最小值(二维下则是左右最高的高度取较小的那一个)作为上界，当前块作为下界
 但是这4个方向每次遍历复杂度过高，且不能像二维那样去提前预存每个方向的最大值
 * 那可以反过来我不以每个块为处理单元，而是以块的四周作为处理单元
 * 那如何保证所有四周的可能性都考虑到呢？
 我们从矩阵的最外围往里面遍历，像一个圈不断缩小的过程
 * 为了防止重复遍历用visited记录
 * 其次要用小顶堆(以高度为判断基准)来存入所有快的四周(即圈是不断缩小的，小顶堆存的就是这个圈)
 * 为什么要用小顶堆？
 这样可以保证高度较小的块先出队
 ** 为什么要让高度较小的块先出队？(关键点)
 1. 一开始时候就讲了基础做法是：对于每一个块，去找它四个方向最高的高度中的最小值(二维下则是左右最高的高度取较小的那一个)作为上界，当前块作为下界
 2. 而我们现在反过来不是以中心块为处理单元，而是以四周作为处理单元
 3. 我们如果能确保当前出队的元素对于该中心块来说是它周围四个高度中的最小值那么就能确定接雨水的大小
 4. 为什么队头元素的高度比中心块要高它就一定是中心块周围四个高度中的最小值呢？
 因为我们的前提就是小顶堆：高度小的块先出队，所以对于中心块来说，先出队的必然是中心块四周高度最小的那一个
 * 步骤：
 1. 构建小顶堆，初始化为矩阵的最外围(边界所有元素)
 2. 不断出队，倘若队头元素的四周(队头元素的四周其实就是上面说的中心块，队头元素是中心块的四周高度中最矮的一个)
 即代表能够接雨水：队头元素减去该中心块即当前中心块能接雨水的值
 3. 但是接完雨水之后中心块还要存进队列中，但这时要存入的中心块是接完雨水后的中心块
 */
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
