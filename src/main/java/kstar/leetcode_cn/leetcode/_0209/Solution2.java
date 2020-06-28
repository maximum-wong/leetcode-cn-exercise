package kstar.leetcode_cn.leetcode._0209;

import java.util.Arrays;

/**
 * <h6>前缀和+二分查找</h6>
 */
public class Solution2 {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int res = Integer.MAX_VALUE;
        // 记录每个位置的前缀和
        int[] sums = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= len; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= len) {
                res = Math.min(res, bound - (i - 1));
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
