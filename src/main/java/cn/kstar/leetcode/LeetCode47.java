package cn.kstar.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h6>全排列 II
 * <br/>Permutations II</h6>
 *
 * <p>给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <br/>Given a collection of numbers that might contain duplicates, 
 * return all possible unique permutations./p>
 * <p><b>Examples:</b></p>
 * <pre>
 * <b>Input:</b> [1,1,2]
 * <b>Output:</b>
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * </pre>
 */
public class LeetCode47 {

    /**
     * <h6>回溯搜索算法</h6>
     * 
     * @param nums
     * @return List<List<Integer>>
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if ((nums == null) || (nums.length == 0)) {
            return result;
        }

        // 排序操作，便于剪枝
        Arrays.sort(nums);
        int length = nums.length;
        // 记录某个位置的数字是否被使用
        boolean[] used = new boolean[length];
        // 记录一个返回结果的集合
        List<Integer> path = new ArrayList<>();
        dfs(nums, length, 0, path, used, result);

        return result;
    }

    /**
     * <h6>使用深度优先算法获取所有的结果</h6>
     * 
     * @param nums
     * @param length
     * @param depth  递归深度
     * @param path
     * @param used
     * @param result
     */
    private void dfs(int[] nums, int length, int depth, List<Integer> path, boolean[] used,
            List<List<Integer>> result) {
        // 递归到叶子节点，添加获取到的结果
        if (depth == length) {
            result.add(new ArrayList<>(path));
        }

        for (int i = 0; i < length; i++) {
            if (used[i]) {
                continue;
            }
            // 去重操作
            if ((i > 0) && (nums[i - 1] == nums[i]) && (!used[i - 1])) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, length, depth + 1, path, used, result);
            used[i] = false;
            path.remove(depth);
        }
    }
}
