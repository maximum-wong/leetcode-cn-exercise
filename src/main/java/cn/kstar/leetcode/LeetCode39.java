package cn.kstar.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h6>组合总和
 * <br/>Combination Sum</h6>
 *
 * <p>给定一个<b>无重复元素</b>的数组 <code>candidates</code> 和一个目标数 <code>target</code> ，
 * 找出 <code>candidates</code> 中所有可以使数字和为 target 的组合。
 * <br/>Given a <b>set</b> of candidate numbers (<code>candidates</code>) <b>(without duplicates)</b> 
 * and a target number (<code>target</code>), find all unique combinations in <code>candidates</code> 
 * where the candidate numbers sums to <code>target</code>.</p>
 * <p><code>candidates</code> 中的数字可以无限制重复被选取。
 * <br/>The <b>same</b> repeated number may be chosen from <code>candidates</code> unlimited number of times.</p>
 * <p><b>说明：</b>
 * <br/><b>Note:</b></p>
 * <ul><li>所有数字（包括 <code>target</code>）都是正整数。
 * <br/>All numbers (including <code>target</code>) will be positive integers.</li>
 * <li>解集不能包含重复的组合。
 * <br/>The solution set must not contain duplicate combinations.</li></ul>
 * <p><b>Example 1:</b></p>
 * <pre>
 * <b>Input: </b>candidates = [2,3,6,7], target = 7,
 * <b>A solution set is: </b>
 * [
 *   [7],
 *   [2, 2, 3]
 * ]
 * </pre>
 * <p><b>Example 2:</b></p>
 * <pre>
 * <b>Input: </b>candidates = [2,3,5], target = 8,
 * <b>A solution set is: </b>
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * </pre>
 */
public class LeetCode39 {

    /**
     * <h6>回溯搜索算法</h6>
     *
     * @param  candidates
     * @param  target
     * @return List<List<Integer>>
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if ((candidates == null) || (candidates.length == 0)) {
            return result;
        }

        // 排序操作，便于剪枝
        Arrays.sort(candidates);
        int length = candidates.length;
        // 记录一个返回结果的集合
        List<Integer> path = new ArrayList<>();
        dfs(candidates, length, 0, 0, target, path, result);

        return result;
    }

    /**
     * <h6>使用深度优先算法获取所有的结果</h6>
     * 
     * @param candidates
     * @param length
     * @param depth  递归深度
     * @param start  开始位置
     * @param target 目标值与当前值之差，其实是倒过来的累加的过程
     * @param path
     * @param result
     */
    private void dfs(int[] candidates, int length, int depth, int start, int target,
            List<Integer> path, List<List<Integer>> result) {
        // 获取到结果
        if (target == 0) {
            result.add(new ArrayList<>(path));
        } else if (target > 0) {
            for (int i = start; i < length; i++) {
                path.add(candidates[i]);
                dfs(candidates, length, depth + 1, i, target - candidates[i], path, result);
                // 重置状态
                path.remove(depth);
            }
        }
    }
}
