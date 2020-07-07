package kstar.leetcode_cn.leetcode._0283;

/**
 * <h6>一次遍历法（双指针法）</h6>
 */
public class Solution2 {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当前元素非0，交换到左边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[slow];
                nums[slow++] = tmp;
            }
        }
    }
}
