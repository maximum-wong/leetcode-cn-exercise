package kstar.leetcode._0367;

/**
 * <h6>奇数累加法</h6>
 *
 */
public class Solution {

    public boolean isPerfectSquare(int num) {
        if (num <= 0) {
            return false;
        }

        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
