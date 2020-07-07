package kstar.leetcode_cn.leetcode._0268;

import java.util.Arrays;

/**
 * <h6>排序法</h6>
 * <p>先排序，利用排序后的数组下标是否等于其元素的值来获取缺失的值</p>
 */
public class Solution2 {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);

        int n = nums.length;

        // 判断n是否出现在末位
        if (nums[n - 1] != n) {
            return n;
        }

        // 判断0是否出现在首位
        if (nums[0] != 0) {
            return 0;
        }

        // 在[1, n)之间寻找缺失的数字
        int expectedNum = 0;
        for (int i = 1; i < nums.length; i++) {
            expectedNum = nums[i - 1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }

        return -1;
    }
}
