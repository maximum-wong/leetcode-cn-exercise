package kstar.leetcode_cn.leetcode._0405;

public class Solution {

    public String toHex(int num) {
        char[] hexNums = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(hexNums[num & 15]);
            num >>>= 4;
        }
        if (sb.length() == 0) {
            sb.append('0');
        }
        return sb.reverse().toString();
    }
}
