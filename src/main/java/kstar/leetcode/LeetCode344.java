package kstar.leetcode;

/**
 * <h6>反转字符串</h6>
 *
 * <p>编写一个函数，其作用是将输入的字符串反转过来。</p>
 * <pre><b>Examples: </b>
 * Input: "hello"; Output: "olleh"
 * 
 * Input: "A man, a plan, a canal: Panama"; Output: "amanaP :lanac a ,nalp a ,nam A"
 * </pre>
 */
public class LeetCode344 {

    /**
     * <p><b>解题思路：</b>
     * <br/>左右指针直接从两边向中间走，同时交换两边字符即可。</p>
     * 
     * @param s
     * @return String
     */
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }
}
