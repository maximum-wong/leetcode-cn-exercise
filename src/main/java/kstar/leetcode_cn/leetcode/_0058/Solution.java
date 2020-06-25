package kstar.leetcode_cn.leetcode._0058;

public class Solution {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // 去除最后一个单词后面的空格
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        // 完全有空格
        if (end < 0) {
            return 0;
        }

        // 记录最后一个单词长度
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }
}
