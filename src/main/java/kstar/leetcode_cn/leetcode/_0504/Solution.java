package kstar.leetcode_cn.leetcode._0504;

public class Solution {

    public String convertToBase7(int num) {

        if (num == 0) {
            return "0";
        }

        boolean sign = true;
        if (num < 0) {
            sign = false;
            num = 0 - num;
        }

        StringBuilder sb = new StringBuilder();
        int digit = 0;
        while (num != 0) {
            digit = num % 7;
            sb.append((char) (digit + '0'));
            num /= 7;
        }
        if (!sign) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
