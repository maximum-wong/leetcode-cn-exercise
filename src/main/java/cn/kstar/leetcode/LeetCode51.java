package cn.kstar.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h6>N皇后</h6>
 *
 * <p><em>n</em> 皇后问题研究的是如何将 <em>n</em> 个皇后放置在 <em>n×n</em> 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <br/>The <em>n</em>-queens puzzle is the problem of placing <em>n</em> queens on an <em>n×n</em> chessboard such 
 * that no two queens attack each other.</p>
 * <p><img src="../../../pic/8-queens.png"></p>
 * <p><small>上图为 8 皇后问题的一种解法。</small></p>
 * <p>给定一个整数 <em>n</em>，返回所有不同的 <em>n</em> 皇后问题的解决方案。
 * <br/>Given an integer <em>n</em>, return all distinct solutions to the <em>n</em>-queens puzzle.</p>
 * <p>每一种解法包含一个明确的 <em>n</em> 皇后问题的棋子放置方案，该方案中 <code>'Q'</code> 和 <code>'.'</code> 分别代表了皇后和空位。
 * <br/>Each solution contains a distinct board configuration of the <em>n</em>-queens' placement, 
 * where <code>'Q'</code> and <code>'.'</code> both indicate a queen and an empty space respectively.</p>
 * <p><strong>示例:</strong>
 * <br/><strong>Example:</strong></p>
 * <pre>
 * <strong>输入(Input): 4</strong>
 * <strong>输出(Output): </strong>[
 *  [".Q..",  // 解法 1 (Solution 1)
 *   "...Q",
 *  "Q...",
 *   "..Q."],
 * 
 *  ["..Q.",  // 解法 2 (Solution 2)
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * <strong>解释</strong>: 4 皇后问题存在两个不同的解法。
 * <strong>Explanation</strong>: There exist two distinct solutions to the 4-queens puzzle as shown above.
 * </pre>
 */
public class LeetCode51 {

    /**
     * <h6>回溯法</h6>
     * 
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[] column = new boolean[n];
        boolean[] left = new boolean[2 * n];
        boolean[] right = new boolean[2 * n];
        dfs(result, new ArrayList<>(), column, left, right, 0);
        return result;
    }

    /**
     * <h6>DFS回溯法</h6>
     * 
     * @param result   返回的结果集
     * @param deep     存放中间结果的栈
     * @param column   每列的标记
     * @param left     左对角线的标记
     * @param right    右对角线的标记
     * @param rowIndex 每行的索引
     */
    private void dfs(List<List<String>> result, List<String> deep, boolean[] column, boolean[] left, boolean[] right,
            int rowIndex) {
        int len = column.length;
        if (len == rowIndex) {
            result.add(new ArrayList<>(deep));
        }

        for (int i = 0; i < len; i++) {
            if (column[i] || left[i + rowIndex] || right[i - rowIndex + len - 1]) {
                continue;
            }
            char[] line = new char[len];
            Arrays.fill(line, '.');
            line[i] = 'Q';
            deep.add(new String(line));
            // 标记
            column[i] = true;
            left[i + rowIndex] = true;
            right[i - rowIndex + len - 1] = true;
            // 递归
            dfs(result, deep, column, left, right, rowIndex + 1);
            // 重置标记
            deep.remove(deep.size() - 1);
            column[i] = false;
            left[i + rowIndex] = false;
            right[i - rowIndex + len - 1] = false;
        }
    }
}
