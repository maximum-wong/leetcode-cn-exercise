package kstar.leetcode_cn.leetcode._0303;

public class NumArray {

    private int[] cache;

    public NumArray(int[] nums) {
        cache = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            cache[i + 1] = cache[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return cache[j + 1] - cache[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */