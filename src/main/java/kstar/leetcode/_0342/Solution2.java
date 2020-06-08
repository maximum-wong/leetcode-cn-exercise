package kstar.leetcode._0342;

public class Solution2 {

    public boolean isPowerOfFour(int num) {

        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }
}
