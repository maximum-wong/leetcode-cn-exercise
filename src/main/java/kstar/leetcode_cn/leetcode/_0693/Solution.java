package kstar.leetcode_cn.leetcode._0693;

public class Solution {

    public boolean hasAlternatingBits(int n) {
        int pre = n & 1;
        n >>>= 1;
        while (n != 0) {
            int curr = n & 1;
            if (pre == curr) {
                return false;
            }
            pre = curr;
            n >>>= 1;
        }
        return true;
    }
}
