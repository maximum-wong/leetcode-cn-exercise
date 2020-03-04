package cn.kstar.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h6>子集
 * <br/>Subsets</h6>
 *
 * <p>给定一组<b>不含重复元素</b>的整数数组 <em>nums</em>，返回该数组所有可能的子集（幂集）。
 * <br/>Given a set of <b>distinct</b> integers, <em>nums</em>, return all possible subsets (the power set).</p>
 * <p><b>说明：</b>解集不能包含重复的子集。
 * <br/><b>Note: </b>The solution set must not contain duplicate subsets.</p>
 * <p><b>Example:</b></p>
 * <pre>
 * <b>Input: </b>nums = [1,2,3]
 * <b>Output: </b>
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * </pre>
 */
public class LeetCode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return ret;
        }

        // 排序进行剪枝优化
        Arrays.sort(nums);

        backtrack(nums, 0, new ArrayList<Integer>(), ret);
        return ret;
    }

    private void backtrack(int[] nums, int start, ArrayList<Integer> path, List<List<Integer>> ret) {
        ret.add(new ArrayList<Integer>(path));
        for (int i = start, len = nums.length; i < len; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1, path, ret);
            path.remove(path.size() - 1);
        }
    }
}
