package kstar.leetcode_cn.leetcode._0041;

/**
 * 为了使时间复杂达到O(n)，需要用hashSet存储数组中的元素，然后针对1~n的数字检查hashSet；
 * 为了使空间复杂度达到常数级，可以用已知的数组进行原地交换。
 */
public class Solution {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 原地交换，使得大小在1~n之间的数字nums[i]被移动到nums[i] - 1位置
            while ((nums[i] > 0) && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        // 遍历以获得答案
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 1~n均在数组当中
        return n + 1;
    }
}
