package kstar.leetcode_cn.leetcode._0171;

public class Solution {

    public int titleToNumber(String s) {
        int res = 0;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num = s.charAt(i) - 'A' + 1;
            res = res * 26 + num;
        }
        return res;
    }

}
