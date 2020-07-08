package kstar.leetcode_cn.leetcode._0461;

public class Solution {

    public int hammingDistance(int x, int y) {
        int xXORy = x ^ y; // 异或获取不同的bit位
        int distance = 0;
        while (xXORy != 0) {
            if ((xXORy & 1) == 1) {
                distance += 1;
            }
            xXORy >>>= 1;
        }
        return distance;
    }
}
