package kstar.leetcode_cn.leetcode._0283;

/**
 * <h6>两次遍历法</h6>
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // 记录非0个数
        int nonZeroCount = 0;
        // 把非0的元素放在左边
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroCount++] = nums[i];
            }
        }

        // 填充右边为0
        for (int i = nonZeroCount; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
