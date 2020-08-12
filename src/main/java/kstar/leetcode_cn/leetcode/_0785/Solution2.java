package kstar.leetcode_cn.leetcode._0785;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <h6>BFS染色法</h6>
 */
public class Solution2 {

    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;

    private int[] color; // 记录每个节点的颜色

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n; i++) {
            if (color[i] == UNCOLORED) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = RED;
                while (!queue.isEmpty()) {
                    Integer node = queue.poll();
                    int otherC = (color[node] == RED) ? GREEN : RED;
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == UNCOLORED) {
                            queue.offer(neighbor);
                            color[neighbor] = otherC;
                        } else if (color[neighbor] != otherC) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
