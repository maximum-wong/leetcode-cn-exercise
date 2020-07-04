package kstar.leetcode_cn.leetcode._0044;

public class Solution {

    public boolean isMatch(String s, String p) {
        int sp = 0;
        int pp = 0;
        int start = -1;
        int tmp = -1;

        while (sp < s.length()) {
            // ? 匹配或相等匹配
            if (pp < p.length() && (p.charAt(pp) == '?' || p.charAt(pp) == s.charAt(sp))) {
                sp++;
                pp++;
            } else if (pp < p.length() && p.charAt(pp) == '*') { // * 匹配，从匹配0个字符开始
                start = pp++;
                tmp = sp;
            } else if (start > -1) { // 回溯至上一个*的下一个位置
                pp = start + 1;
                sp = ++tmp;
            } else { // 不匹配
                return false;
            }
        }

        // 判断p剩余的字符是否为*
        for (int i = pp; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }

        return true;
    }
}
