package kstar.leetcode._0680;

/**
 * <h6>双指针法</h6>
 */
public class Solution {

    public boolean validPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            char left = s.charAt(low);
            char right = s.charAt(high);
            if (left == right) {
                low++;
                high--;
            } else {
                boolean lFlag = true;
                boolean rFlag = true;
                // 判断[low, high-1]区间是否回文
                for (int i = low, j = high - 1; i < j; i++, j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        lFlag = false;
                        break;
                    }
                }
                // 判断[low+1, high]区间是否回文
                for (int i = low + 1, j = high; i < j; i++, j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        rFlag = false;
                        break;
                    }
                }
                return lFlag || rFlag;
            }
        }
        return true;
    }
}
