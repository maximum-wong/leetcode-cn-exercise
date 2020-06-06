package kstar.leetcode._0045;

/**
 * <h6>贪心法</h6>
 * <p>时间复杂度：O(n)；空间复杂度：O(1)</p>
 */
public class Solution {

    public int jump(int[] nums) {

        if (nums == null || nums.length < 2) {
            return 0;
        }

        // 申请结果变量
        int result = 0;
        // 边界标志
        int flag = 0;
        // 边界更新变量
        int end = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            // 边界更新变量如果到达最后一个元素，直接返回结果
            if ((end = Math.max(end, nums[i] + i)) == nums.length - 1) {
                return ++result;
            }

            // 否则达到边界时更新边界
            if (i == flag) {
                flag = end;
                ++result;
            }
        }

        return result;
    }
}
