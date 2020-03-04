package cn.kstar.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
