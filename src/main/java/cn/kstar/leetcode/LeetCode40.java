package cn.kstar.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h6>组合总和 II
 * <br/>Combination Sum II</h6>
 *
 * <p>给定一个数组 <code>candidates</code> 和一个目标数 <code>target</code> ，
 * 找出 <code>candidates</code> 中所有可以使数字和为 <code>target</code> 的组合。
 * <br/>Given a collection of candidate numbers (<code>candidates</code>) and a target number (<code>target</code>), 
 * find all unique combinations in <code>candidates</code> where the candidate numbers sums to <code>target</code>.</p>
 * <p>candidates 中的每个数字在每个组合中只能使用一次。
 * <br/>Each number in <code>candidates</code> may only be used <b>once</b> in the combination.</p>
 * <p><b>说明：</b>
 * <br/><b>Note:</b></p>
 * <ul><li>所有数字（包括目标数）都是正整数。
 * <br/>All numbers (including <code>target</code>) will be positive integers.</li>
 * <li>解集不能包含重复的组合。
 * <br/>The solution set must not contain duplicate combinations.</li></ul>
 * <p><b>Example 1:</b></p>
 * <pre>
 * <b>Input: </b>candidates = [10,1,2,7,6,1,5], target = 8,
 * <b>A solution set is: </b>
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * </pre>
 * <p><b>Example 2:</b></p>
 * <pre>
 * <b>Input: </b>candidates = [2,5,2,1,2], target = 5,
 * <b>A solution set is: </b>
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * </pre>
 */
public class LeetCode40 {

    /**
     * <h6>回溯搜索算法</h6>
     *
     * @param  candidates
     * @param  target
     * @return List<List<Integer>>
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if ((candidates == null) || (candidates.length == 0)) {
            return result;
        }

        // 排序操作，便于剪枝
        Arrays.sort(candidates);
        // 记录一个返回结果的集合
        List<Integer> path = new ArrayList<>();
        dfs(candidates, 0, target, path, result);

        return result;
    }

    /**
     * <h6>使用深度优先算法获取所有的结果</h6>
     * 
     * @param candidates
     * @param start      开始位置
     * @param target     目标值与当前值之差，其实是倒过来的累加的过程
     * @param path
     * @param result
     */
    private void dfs(int[] candidates, int start, int target, List<Integer> path,
            List<List<Integer>> result) {
        // 获取到结果
        if (target == 0) {
            result.add(new ArrayList<>(path));
        } else if (target > 0) {
            for (int i = start, len = candidates.length; i < len; i++) {
                // 去重操作
                if ((i > start) && (candidates[i] == candidates[i - 1])) {
                    continue;
                }
                path.add(candidates[i]);
                dfs(candidates, i + 1, target - candidates[i], path, result);
                // 重置状态
                path.remove(path.size() - 1);
            }
        }
    }
}
