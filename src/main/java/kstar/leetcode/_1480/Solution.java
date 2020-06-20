package kstar.leetcode._1480;

public class Solution {

    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0, len= nums.length; i < len; i++) {
            sum+=nums[i];
            nums[i] = sum;
        }
        return nums;
    }
}
