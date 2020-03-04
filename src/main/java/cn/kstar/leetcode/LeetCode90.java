package cn.kstar.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
            if (ret.contains(path)) {
                path.remove(path.size() - 1);
                continue;
            }
            backtrack(nums, i + 1, path, ret);
            path.remove(path.size() - 1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return ret;
        }

        // 排序进行剪枝优化
        Arrays.sort(nums);

        backtrack2(nums, 0, new ArrayList<Integer>(), ret);
        return ret;
    }

    private void backtrack2(int[] nums, int start, ArrayList<Integer> path, List<List<Integer>> ret) {
        ret.add(new ArrayList<Integer>(path));
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = start; i < len; i++) {
            if (map.get(nums[i]) != null) {
                continue;
            }
            map.put(nums[i], i);
            path.add(nums[i]);
            backtrack(nums, i + 1, path, ret);
            path.remove(path.size() - 1);
        }
    }
}
