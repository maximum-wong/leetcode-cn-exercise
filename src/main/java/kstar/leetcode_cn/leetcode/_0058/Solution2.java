package kstar.leetcode_cn.leetcode._0058;

public class Solution2 {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                // 如果没有统计到有效字符长度，遇到空格，继续向前走
                if (count == 0) {
                    continue;
                } else { // 如果统计到有效字符长度，遇到空格，就得到最后一个单词的长度
                    break;
                }
            }
            count++;
        }

        return count;
    }
}
