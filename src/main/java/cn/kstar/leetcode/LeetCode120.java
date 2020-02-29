package cn.kstar.leetcode;

import java.util.List;

/**
 * <h6>三角形最小路径和</h6>
 *
 * <p>给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * </br>Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.</p>
 * <p>例如，给定三角形：
 * <br/>For example, given the following triangle</p>
 * <pre>
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * </pre>
 * <p>自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <br/>The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).</p>
 * <p><b>说明：</b>
 * <br/><b>Note:</b></p>
 * <p>如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <br/>Bonus point if you are able to do this using only O(n) extra space, 
 * where n is the total number of rows in the triangle.</p>
 */
public class LeetCode120 {

    /**
     * <h6>动态规划法</h6>
     * 
     * <ul><li>问题拆解：
     * <br/>此处求最小路径和，要经过多个位置，到达[i][j]位置，要经过[i-1][j]或[i-1][j-1]，因此到达某个位置要经过上面一个或两个位置的路径</li>
     * <li>状态定义：
     * <br/>如果从上往下实现，在考虑下面元素时，每行起始元素只能从[i-1][j]获得，终止元素只能从[i-1][j-1]获的，中间的皆可，这样不好实现。
     * 如果从下往上实现，因为每个位置的路径值是不变的，所以方向不影响最终答案。因此状态就变成 “最后一行元素到当前元素的最小路径和”，
     * 对于[0][0]来说，最后状态表示的就是最终答案</li>
     * <li>递推方程：
     * <br/>dp[i][j] = min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j]</li>
     * <li>实现：
     * <br/>此处初始化时，需要将最后一行的元素填入状态数组中，按照前面的分析策略，从下往上计算即可</li></ul>
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        
        // 获取行数
        int row = triangle.size();
        int[][] dp = new int[row][row];
        // 获取最后一行
        List<Integer> lastRow = triangle.get(row - 1);

        // 初始化最后一行
        for (int i = 0; i < row; i++) {
            dp[row - 1][i] = lastRow.get(i);
        }

        for (int i = row - 1; i >= 0; i--) {
            List<Integer> currentRoe = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                int prevDpVal = (dp[i + 1][j] > dp[i + 1][j + 1]) ? dp[i + 1][j] : dp[i + 1][j + 1];
                dp[i][j] = prevDpVal + currentRoe.get(j);
            }
        }

        return dp[0][0];
    }
}
