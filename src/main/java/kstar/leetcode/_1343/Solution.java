package kstar.leetcode._1343;

/**
 * <h6>滑动窗口法</h6>
 */
public class Solution {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int len = arr.length;
        int[] table = new int[len];
        table[0] = arr[0];
        for (int i = 1; i < len; i++) {
            table[i] = table[i - 1] + arr[i];
        }
        int res = 0;
        int sum = k * threshold;
        int left = 0;
        int right = k - 1;
        while (right <= len - 1) {
            if (table[right] - table[left] + arr[left] >= sum) {
                res++;
            }
            left++;
            right++;

        }
        return res;
    }
}
