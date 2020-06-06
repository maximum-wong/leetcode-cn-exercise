package kstar.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h6>组合
 * <br/>Combinations</h6>
 *
 * <p>给定两个整数 <em>n</em> 和 <em>k</em>，返回 1 ...<em>n</em> 中所有可能的 <em>k</em> 个数的组合。
 * <br/>Given two integers <em>n</em> and <em>k</em>, 
 * return all possible combinations of <em>k</em> numbers out of 1 ... <em>n</em>.</p>
 * <p><b>Example: </b></p>
 * <pre>
 * <b>Input: </b>n = 4, k = 2
 * <b>Output: </b>
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4]
 * ]
 * </pre>
 */
public class LeetCode77 {

    /**
     * <h6>回溯搜索算法</h6>
     * 
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        
        if (n<1 || k<1) {
            return ret;
        }
        
        // 保存一个返回结果的容器
        List<Integer> path = new ArrayList<>();
        backtrack(n, k, 1, path, ret);
        
        return ret;
    }

    /**
     * <h6>使用回溯算法</h6>
     * 
     * @param n
     * @param k
     * @param start
     * @param path
     * @param ret
     */
    private void backtrack(int n, int k, int start, List<Integer> path, List<List<Integer>> ret) {
        // 递归终止条件
        if (k == path.size()) {
            ret.add(new ArrayList<>(path));
        } else if (k > path.size()) {
            for (int i = start; i <= n; i++) {
                path.add(i);
                // 向下递归
                backtrack(n, k, i + 1, path, ret);
                // 恢复之前状态
                path.remove(path.size() - 1);
            }
        }
    }
}
