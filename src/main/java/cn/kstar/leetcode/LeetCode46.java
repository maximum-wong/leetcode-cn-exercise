package cn.kstar.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h6>全排列
 * <br/>Permutations</h6>
 *
 * <p>给定一个<b>没有重复</b>数字的序列，返回其所有可能的全排列。
 * <br/>Given a collection of <b>distinct</b> integers, return all possible permutations.</p>
 * <p><b>Examples:</b></p>
 * <pre>
 * <b>Input:</b> [1,2,3]
 * <b>Output:</b>
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * </pre>
 */
public class LeetCode46 {

    /**
     * <h6>回溯搜索算法</h6>
     * 
     * @param nums
     * @return List<List<Integer>>
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int length = nums.length;
        boolean[] used = new boolean[length];
        List<Integer> path = new ArrayList<>();

        dfs(nums, length, 0, path, used, result);
        return result;
    }

    private void dfs(int[] nums, int length, int depth, List<Integer> path, boolean[] used,
            List<List<Integer>> result) {
        if (depth == length) {
            result.add(new ArrayList<>(path));
        }

        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, length, depth + 1, path, used, result);
                // 重置状态
                used[i] = false;
                path.remove(depth);
            }
        }
    }

}
