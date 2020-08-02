package kstar.leetcode_cn.leetcode._0013;

import java.util.HashMap;
import java.util.Map;

/**
 * <h6>查表法</h6>
 */
public class Solution {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ret = 0;
        int preNum = map.get(s.charAt(0));

        for (int i = 1, length = s.length(); i < length; i++) {
            int num = map.get(s.charAt(i));
            if (preNum < num) { // 左边的数字小于右边的数字
                ret = -preNum;
            } else { // 左边的数字大于等于右边的数字
                ret += preNum;
            }
            preNum = num;
        }
        return ret;
    }
}
