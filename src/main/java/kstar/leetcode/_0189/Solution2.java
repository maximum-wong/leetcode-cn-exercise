package kstar.leetcode._0189;

/**
 * <h6>环状替换法</h6>
 *
 */
public class Solution2 {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int len = nums.length;
        k = k % len;
        int count = 0;
        for (int start = 0; count < len; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % len;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
