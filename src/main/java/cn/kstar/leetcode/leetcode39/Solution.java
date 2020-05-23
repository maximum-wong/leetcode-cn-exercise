package cn.kstar.leetcode.leetcode39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h6>回溯搜索算法</h6>
 *
 */
public class Solution {


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
