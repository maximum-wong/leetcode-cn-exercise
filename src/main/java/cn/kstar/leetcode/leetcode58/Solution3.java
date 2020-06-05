package cn.kstar.leetcode.leetcode58;

public class Solution3 {

    /**
     * <h6>正序法
     * <h6>
     * 
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int ret = 0;
        if (s == null || s.length() == 0) {
            return ret;
        }

        // 每个单词的长度
        int wordLen = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i) == ' ') {
                wordLen = 0;
            } else {
                wordLen++;
                ret = wordLen;
            }
        }

        return ret;
    }

}
