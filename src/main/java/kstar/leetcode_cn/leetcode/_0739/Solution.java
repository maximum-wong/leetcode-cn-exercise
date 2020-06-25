package kstar.leetcode_cn.leetcode._0739;

public class Solution {

    public int[] dailyTemperatures(int[] T) {
        int[] stack = new int[T.length];
        int top = -1;
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (top >= 0 && T[i] > T[stack[top]]) {
                int idx = stack[top--];
                res[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return res;
    }
}
