package kstar.leetcode_cn.leetcode._0728;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDiving(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isSelfDiving(int n) {
        int num = n;
        int digit = 0;

        while (num != 0) {
            digit = num % 10;
            if (digit == 0) {
                return false;
            }
            if (n % digit != 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
