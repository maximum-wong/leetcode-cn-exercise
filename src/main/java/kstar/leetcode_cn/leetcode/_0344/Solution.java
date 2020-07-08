package kstar.leetcode_cn.leetcode._0344;

/**
 * <p><b>解题思路：</b>
 * <br/>左右指针直接从两边向中间走，同时交换两边字符即可。</p>
 */
public class Solution {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
