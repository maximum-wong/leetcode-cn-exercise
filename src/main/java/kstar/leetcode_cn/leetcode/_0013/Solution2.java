package kstar.leetcode_cn.leetcode._0013;

import java.util.HashMap;
import java.util.Map;

/**
 * <h6>函数法</h6>
 */
public class Solution2 {

    public int romanToInt(String s) {
        int ret = 0;
        int preNum =getValue(s.charAt(0));

        for (int i = 1, length = s.length(); i < length; i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) { // 左边的数字小于右边的数字
                ret = -preNum;
            } else { // 左边的数字大于等于右边的数字
                ret += preNum;
            }
            preNum = num;
        }
        return ret;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
