package kstar.leetcode_cn.leetcode._0371;

public class Solution {

    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        int lower;
        int carrier;
        while (true) {
            lower = a ^ b; // 计算低位
            carrier = a & b; // 计算进位
            if (carrier == 0) {
                break;
            }
            a = lower;
            b = carrier << 1;
        }
        return lower;
    }
}
