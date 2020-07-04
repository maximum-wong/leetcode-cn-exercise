package kstar.leetcode_cn.leetcode._0989;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> addToArrayForm(int[] A, int K) {

        if (A == null || A.length == 0) {
            return new LinkedList<>();
        }

        LinkedList<Integer> res = new LinkedList<>();
        int carry = 0;
        int num = 0;
        int idx = A.length - 1;
        while (idx >= 0 || K > 0) {
            num = K % 10 + A[idx] + carry;
            res.addFirst(num % 10);
            carry = num / 10;
            idx--;
            K /= 10;
        }
        return res;
    }
}
