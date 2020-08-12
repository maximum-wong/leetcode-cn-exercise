package kstar.leetcode_cn.leetcode._0785;

import java.util.Arrays;

/**
 * <h6>DFS染色法</h6>
 */
public class Solution {

    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;

    private int[] color; // 记录每个节点的颜色
    private boolean valid; // 是否为二分图

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        valid = true;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n && valid; i++) {
            if (color[i] == UNCOLORED) {
                dfs(i, RED, graph);
            }
        }
        return valid;
    }

    /**
     * <h6>使用DFS法给每个节点染色，并判断是否为二分图</h6>
     * @param node
     * @param c
     * @param graph
     */
    private void dfs(int node, int c, int[][] graph) {
        color[node] = c;
        int otherC = (c == RED) ? GREEN : RED;
        for (int neighbor : graph[node]) {
            if (color[neighbor] == UNCOLORED) {
                dfs(neighbor, otherC, graph);
                if (!valid) {
                    return;
                }
            } else if (color[neighbor] != otherC) {
                valid = false;
                return;
            }
        }
    }
}
