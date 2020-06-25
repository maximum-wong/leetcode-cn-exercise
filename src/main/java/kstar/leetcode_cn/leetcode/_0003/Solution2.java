package kstar.leetcode_cn.leetcode._0003;

/**
 * <h6>滑动窗口法</h6>
 *
 * <p>时间复杂度：O(s.length)；空间复杂度：O(slideWindow.length)</p>
 *
 * <p>建立一个128位大小的整型数组slideWindow，用来建立字符和其出现位置之间的映射。
 * </br>维护一个滑动窗口，窗口内的都是没有重复的字符，去尽可能的扩大窗口的大小，窗口不停的向右滑动。</p>
 * <li>(1) 如果当前遍历到的字符从未出现过，那么直接扩大右边界；</li>
 * <li>(2) 如果当前遍历到的字符出现过，则缩小窗口（左边索引向右移动），然后继续观察当前遍历到的字符；</li>
 * <li>(3) 重复(1)、(2)，直到左边索引无法再移动；</li>
 * <li>(4) 维护一个结果res，每次用出现过的窗口大小来更新结果res，最后返回res获取结果。</li>
 */
public class Solution2 {

    public int lengthOfLongestSubstring2(String s) {
        if ((s == null) || (s.length() == 0)) {
            return 0;
        }

        int[] slideWindow = new int[128];
        // 滑动窗口为slideWindow[left...right)
        int left = 0;
        int right = 0;
        int res = 0;
        // 整个循环从 left == 0; right == 0 这个空窗口开始
        // 到left == s.length(); right == s.length() 这个空窗口截止
        // 在每次循环里逐渐改变窗口, 维护slideWindow, 并记录当前窗口中是否找到了一个新的最优值
        int length = s.length();
        while ((left < length) && (right < length)) {
            if (slideWindow[s.charAt(right)] == 0) {
                slideWindow[s.charAt(right)]++;
                right++;
                res = Math.max(res, right - left);
            } else { // right已经到头 || slideWindow[s.charAt(right)] == 1
                slideWindow[s.charAt(left)]--;
                left++;
            }
        }
        return res;
    }
}
